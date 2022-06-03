package com.exemple.hotel.cli;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.exemple.hotel.models.Agency;
import com.exemple.hotel.models.Offre;
import com.exemple.hotel.models.chambre;
import com.exemple.hotel.models.hotel;

@Component
public class HotelRestClientCLI extends AbstractMain implements CommandLineRunner {

	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private String AGENCY_SERVICE_URL;
	private String HOTEL_SERVICE_URL;
	private static final Long idAgence = 1L;
	private List <Offre> offres = new ArrayList<>();
	
	public void run(String... args) throws Exception {
	
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			inputReader = new BufferedReader(
					new InputStreamReader(System.in));
			setTestServiceUrl(inputReader);		
			AGENCY_SERVICE_URL = "http://localhost:8000/agences/api";
			HOTEL_SERVICE_URL =  "http://localhost:8000/hotels/api";

			
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader, userInput, proxy);
				Thread.sleep(3000);
				
			} while(!userInput.equals(QUIT));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*protected boolean validServiceWSDLUrl() {
		return SERVICE_URL.equals(
				"http://localhost:8000/hotelservice/api");
	}:*/
	

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n réponse à la question 1. Consulter les disponibilités à travers une agences partenaires ");
		builder.append("\n réponse à la question 2. Effectuer une réservation à partir d'un identifiant offre");
		builder.append("\n réponse à la question 3  Comparer les offres proposées par les agences partenaires");

		
		System.out.println(builder);
	}

	private void processUserInput(BufferedReader reader, 
			String userInput, RestTemplate proxy) {
		Map<String, String> params = new HashMap<>();
		inputProcessor = new IntegerInputProcessor(reader);
		try { 
			switch(userInput) {
				case "1":
			
					//user input
					String uri = AGENCY_SERVICE_URL+"/agencies/{id}/hotels";
					System.out.println("Votre date d'arrivé :fromat [YYYY-MM-DD]");
					String arrival = reader.readLine();
					System.out.println("Votre date de départ :fromat [YYYY-MM-DD]");
					String departure = reader.readLine();
					System.out.println("Nombre de personnes à hébérger");
					int nbplace = inputProcessor.process();
					
					//passer les paramères
					params.put("id", String.valueOf(idAgence));
					params.put("Departure", departure);
					params.put("Arrival", arrival);
					params.put("nblits", String.valueOf(nbplace));
					
					//fetch from url
					String urlTemplate = UriComponentsBuilder.fromUriString(uri)
							.queryParam("Departure", "{Departure}")
							.queryParam("Arrival", "{Arrival}")
							.queryParam("nblits", "{nblits}")
							.encode()
							.toUriString();
					Agency agence =  proxy.getForObject(urlTemplate, Agency.class, params);

					//stocker l'offre
					for (hotel h : agence.getHotels()) {
						for (chambre c : h.getChambres()) {
							Offre offre = new Offre();
							int ref = new Random().ints(1,10000,99999).findFirst().getAsInt();
							offre.setChambre_id(c.getId());
							offre.setArrival(LocalDate.parse(arrival));
							offre.setDeparture(LocalDate.parse(departure));
							offre.setOffreReference(ref);
							offre.setAgence_id(idAgence);
							this.offres.add(offre);
							
				   //affichage
							System.out.println("			Hotel : " + h.getName());
							System.out.println("Cet Hotel ce situe à " + h.getAdress().getCity() + " à " + h.getAdress().getStreetNumber() + " " + h.getAdress().getStreet());
							System.out.println("Il contient un/une " + c.getCategory() + " avec un prix de reservation :" + c.getPrice());
							System.out.println("		Si vous souhaitez reserver cette chambre, veuillez conserver votre identifiant de l'offre  :"
									+ "\n  									[" + ref + "]");
							BufferedImage image = ImageIO.read(getClass().getResource(c.getImage()));
							System.out.print(image);
							//JFrame frame = new JFrame();
							//frame.setIconImage
							//(new ImageIcon(getClass().getResource(c.getImage())).getImage()); -> this don't work, i never dealed with images before

						}
					}
					
					break;	
				case "2":
					uri = HOTEL_SERVICE_URL + "/reserver";
					
					//user input
					System.out.println("Veuillez saisir votre identifiant de votre agence ");
					int idAgence = inputProcessor.process();
					System.out.println("Veuillez saisir votre identifiant de l'offre ");
					int identifiantoffre = inputProcessor.process();
				
					//chercher l'offre par son idagence et idoffre
					Offre CreatedOffre = new Offre();
					for (Offre offre : this.offres) {
						if (offre.getOffreReference() == identifiantoffre
							&& offre.getAgence_id() == idAgence)
						{CreatedOffre = offre;}
					}
					System.out.println("votre prénom :");
					String Name = reader.readLine();
					System.out.println("Votre Nom :");
					String LastName = reader.readLine();
					System.out.println("Vos information de carte bancaires :");
					int cb = inputProcessor.process();
					//stocker les informations personnelles du personnage principale
					CreatedOffre.setName(Name);
					CreatedOffre.setLastName(LastName);
					CreatedOffre.setCb(cb);
					CreatedOffre.setReservationReference(LastName + String.valueOf(CreatedOffre.getOffreReference()) + CreatedOffre.getDeparture());			
								
					//l'envoie de l'objet qui contient les paramètres qui nous intéréssent
					proxy.postForObject(uri, CreatedOffre, Offre.class);
					System.out.println("Votre reservation a été effectué avec succés, veuillez conservez votre numéro de reservation " + CreatedOffre.getReservationReference());
	
							/*HttpHeaders headers = new HttpHeaders();
							headers.setContentType(MediaType.APPLICATION_JSON);
							HttpEntity<Offre> request = new HttpEntity<Offre>(CreatedOffre, headers);
							ResponseEntity<Offre> response = 
								    proxy.exchange(uri, HttpMethod.POST, request,
								        Offre.class );*/		
					break;
		
				case "3":
					uri = AGENCY_SERVICE_URL + "/agencies/{id}/hotels";
					
					//userinput
					System.out.println("Veuillez saisir votre ville de recherche");
					String city = reader.readLine();
					System.out.println("Minimum d'étoiles recherchées");
					int nbetoile = inputProcessor.process();
					System.out.println("Votre date d'arrivé :fromat [YYYY-MM-DD]");
					arrival = reader.readLine();
					System.out.println("Votre date de départ :fromat [YYYY-MM-DD]");
					departure = reader.readLine();
					System.out.println("Nombre de personnes à hébérger");
					nbplace = inputProcessor.process();
					
					List <hotel> listefinale = new ArrayList<>();
					for (Long id =1L; id <3L; id++) {
						//passer les paramères
						params.put("id", String.valueOf(id));
						params.put("Departure", departure);
						params.put("Arrival", arrival);
						params.put("nblits", String.valueOf(nbplace));
						
						//fetch from url
						urlTemplate = UriComponentsBuilder.fromUriString(uri)
								.queryParam("Departure", "{Departure}")
								.queryParam("Arrival", "{Arrival}")
								.queryParam("nblits", "{nblits}")
								.encode()
								.toUriString();
						
						Agency agency =  proxy.getForObject(urlTemplate, Agency.class, params);
					
						for (hotel h : agency.getHotels()) {
							if (h.getAdress().getCity().equalsIgnoreCase(city)
									&& h.getStars() >= nbetoile
									&& !listefinale.contains(h)) {
								System.out.println("			Hotel : " + h.getName() + ", géré par l'agence avec l'id : ["+ agency.getId()+"] " + agency.getName());
								System.out.println("	 " + h.getAdress().getCity() + " à " + h.getAdress().getStreetNumber() + " " + h.getAdress().getStreet());
								
								//stocker l'offre
								listefinale.add(h);
								for (chambre c : h.getChambres()) {
									Offre offre = new Offre();
									int ref = new Random().ints(1,10000,99999).findFirst().getAsInt();
									offre.setChambre_id(c.getId());
									offre.setArrival(LocalDate.parse(arrival));
									offre.setDeparture(LocalDate.parse(departure));
									offre.setOffreReference(ref);
									offre.setAgence_id(id);
									System.out.println("	Il contient un/une " + c.getCategory() + " avec un prix de reservation :" + c.getPrice());
									System.out.println("		Si vous souhaitez reserver cette chambre, veuillez conserver votre identifiant de l'offre  :"
											+ "\n  									[" + ref + "]");	
									this.offres.add(offre);
								}
							}
						}
					}
					break;
					
				/*case "4":
					uri = URI_HOTEL;
					System.out.println("Hotel name");
					String name = reader.readLine();
					hotel createdHotel = new hotel(id, name, null, id, null, agency);
					hotel returnedHotel = proxy.postForObject(uri, createdHotel, hotel.class);
					System.out.println("Successful" + returnedHotel);
					System.out.println();
					break;*/
			
					
				case QUIT:
					System.out.println("Bye...");
					System.exit(0);				
				default:
					System.err.println("Sorry, wrong input. Please try again.");
					return;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}


}
