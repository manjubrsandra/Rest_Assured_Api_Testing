package _Automation.Spotify;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class spotify {
	
	public String token= "Bearer BQADm5Ff5dLPfFc_kEgAfbdxSKMxFQ8HJ8dOGX1i7ihUwrpoX9s_HlGgTiJS8ZZPzBhphmIGkOEK89QLnINOfLF2MuHLsdwnqSBS6eqImtQJtEJPACWXNu7TI3-gyjLfIecPk_VG9FzUnBRVH-8ofdgCruMqwV5KQe3XadIBxQ8T6kn2DNNc6vH2whBFe3AiouA2KZaSZWZWzv3nmrCsDgZUN-4SklnOjr4gaSZR";
	public String userId = "31cdzaerscgkvsi6t7kuc3a6qdem";
	// User
	@Test
     public void get_Request_Get_Current_Users_Profile() {
    	 Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me");
 		response.prettyPrint();
 		response.then().statusCode(200);
 		String name=response.path("display_name");
 		Assert.assertEquals("Manjunath", name);
 		Assert.assertEquals(200,response.getStatusCode());
     }
	@Test
	public void get_Request_Get_Users_Profile() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/users/" + userId);
 		response.prettyPrint();
 		response.then().statusCode(200);
 		String name=response.path("display_name");
 		Assert.assertEquals("Manjunath", name);
 		System.out.println(name);
		
	}
	
	// Playlist
	@Test
	public void post_Request_Add_playlist() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"name\":\"Kannada Playlist\",\"description\":\"New playlist description\",\"public\":false}")
 				.when()
 				.post("https://api.spotify.com/v1/users/"+userId+"/playlists");
 		response.prettyPrint();
 		String Name=response.path("name");
 		Assert.assertEquals("Kannada Playlist",Name);
 		System.out.println(Name);
	}
	@Test
	public void post_Request_Add_Playlist_items() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.post("https://api.spotify.com/v1/playlists/1TXSj3GOn2qq2rYxMMZuWY/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
 		response.prettyPrint();
 		
		
	}
	@Test
	public void get_Request_User_Playlist() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/users/"+userId+"/playlists");
 		response.prettyPrint();
 	
	}
	@Test
	public void get_Request_Playlist_ByID() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/playlists/1TXSj3GOn2qq2rYxMMZuWY");
 		response.prettyPrint();
 		
 		response.then().statusCode(200);
 		String Name=response.path("name");
 		Assert.assertEquals("Darshan Playlist Name", Name);
 		System.out.println(Name);
		
	}
	@Test
	public void get_Request_Get_Playlist_Items() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/playlists/1TXSj3GOn2qq2rYxMMZuWY/tracks");
 		response.prettyPrint();
 		response.then().statusCode(200);
 		
	}
	@Test
	public void get_Request_Playlist_Cover_Image() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/playlists/1TXSj3GOn2qq2rYxMMZuWY/images");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
    public void get_Request_Current_Users_Playlists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/playlists");
 		response.prettyPrint();
 		response.then().statusCode(200);
    }
	@Test
	public void put_Request_Change_Playlist_Details() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"name\":\"Darshan Playlist Name\",\"description\":\"Updated playlist description\",\"public\":false}")
 				.when()
 				.put("https://api.spotify.com/v1/playlists/5vFslRvaAlD6Wzg0O8afvh");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void put_Request_Update_Playlist_Items () {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"name\":\"Darshan Playlist Name\",\"description\":\"Updated playlist description\",\"public\":false}")
 				.when()
 				.put("https://api.spotify.com/v1/playlists/5vFslRvaAlD6Wzg0O8afvh");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Search
	@Test
	public void Search_Method(){
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.pathParam("q", "Darshan")
 				.pathParam("type", "track")
 				//.queryParam("q","Darshan")
 				//.queryParam("type","track")
 				.when()
 				.get("https://api.spotify.com/v1/search?q={q}&type={type}");
		        //.get("https://api.spotify.com/v1/search")
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Tracks
	@Test
	public void get_Request_Get_Track(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Several_Tracks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.pathParam("Id", "7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B")
 				.when()
 				.get("https://api.spotify.com/v1/tracks?ids={Id}");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Tracks_Audio_Features(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Tracks_Audio_Analysis(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Tracks_Audio_Features_ByID(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.pathParam("id", "7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B")
 				.when()
 				.get("https://api.spotify.com/v1/audio-features?ids={id}");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Shows
	@Test
	public void get_Request_Get_Show_ByID(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Show_Episodes(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Several_Shows(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/shows?market=ES&ids=5vFslRvaAlD6Wzg0O8afvh");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Personolisation
	@Test
	public void get_Request_Get_Users_Top_Items(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/top/artists?time_range=medium_term&limit=10&offset=5");
 		response.prettyPrint();
	}
	
	//Markets
	@Test
	public void get_Request_Get_Available_Markets(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/markets\" -H \"Accept: application/json");
 		response.prettyPrint();
 		response.then().statusCode(404);
	}
	
	//Follow
	@Test
	public void get_Request_Check_if_Users_Follow_Playlist(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
 		response.prettyPrint();
 		response.then().statusCode(502);
	}
	@Test
	public void get_Request_Get_Followed_Artists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
 		response.prettyPrint();
 		response.then().statusCode(502);
	}
	@Test
	public void get_Request_Check_If_User_Follows_Artists_or_Users(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Follow_Playlist() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"public\":true}")
 				.when()
 				.put("https://api.spotify.com/v1/playlists/5vFslRvaAlD6Wzg0O8afvh/followers");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Follow_Artists_or_Users() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/following?type=artist&ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
	}
	@Test
	public void delete_Request_Unfollow_Playlist() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
 		response.prettyPrint();
	}
	@Test
	public void delete_Request_Unfollow_Artists_or_Users() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
 		response.prettyPrint();
	}
	
	// Episodes
	@Test
	public void get_Request_Get_Episode(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Several_Episodes(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/episodes?ids=5vFslRvaAlD6Wzg0O8afvh");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Chapters
	@Test
	public void get_Request_Get_a_Chapter(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/chapters/1TXSj3GOn2qq2rYxMMZuWY?market=ES");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Several_Chapters(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Browse
	@Test
	public void get_Request_Get_Recommendations(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_New_Releases(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Featured_Playlists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/browse/featured-playlists?country=SE");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Categorys_Playlists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/browse/categories/dinner/playlists?country=SE&limit=10&offset=5");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Single_Browse_Category(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/browse/categories/dinner?country=SE&locale=sv_SE");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Several_Browse_Categories(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Available_Genre_Seeds(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Audio books
	@Test
	public void get_Request_Get_an_Audiobook(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ?market=ES");
 		response.prettyPrint();
 		response.then().statusCode(500);
	}
	@Test
	public void get_Request_Get_Several_Audiobooks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Artists
	@Test
	public void get_Request_Get_Several_Artists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
 		response.prettyPrint();
 		
	}
	@Test
	public void get_Request_Get_Artist(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Artists_Top_Tracks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Artists_Related_Artists(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Albums
	@Test
	public void get_Request_Get_Artists_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Several_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Album(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	@Test
	public void get_Request_Get_Album_Tracks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
 		response.prettyPrint();
 		response.then().statusCode(200);
	}
	
	// Library
	@Test
	public void get_Request_Get_Users_Saved_Shows(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/shows?limit=10&offset=5");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Users_Saved_Episodes(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/episodes?market=ES&limit=10&offset=5");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Get_Saved_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/albums?limit=10&offset=5&market=ES");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Check_Users_Saved_Tracks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/tracks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Check_Users_Saved_Episodes(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/episodes/contains?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
 		response.prettyPrint();
	}
	@Test
	public void get_Request_Check_Saved_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Save_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
 		response.prettyPrint();
 		response.then().statusCode(403);
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void put_Request_Save_Episodes_for_User(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
 		response.prettyPrint();
 		response.then().statusCode(403);
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void put_Request_Save_Shows_for_Current_User(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
 		response.prettyPrint();
 		response.then().statusCode(403);
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void put_Request_Save_Tracks_for_Current_User(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
 		response.then().statusCode(403);
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void delete_Request_Remove_Albums(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
 		response.prettyPrint();
 		response.then().statusCode(403);
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void delete_Request_Remove_Users_Saved_Episodes(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/me/episodes?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void delete_Request_Remove_Users_Saved_Shows(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ&market=ES");
 		response.prettyPrint();
 		String Name=response.path("error.message");
 		Assert.assertEquals("Insufficient client scope",Name);
 		System.out.println(Name);
	}
	@Test
	public void delete_Request_Remove_Tracks_for_Current_User(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.delete("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
 		response.prettyPrint();
 		
	}
	
	// Player
	@Test
	public void get_Request_Get_the_Users_Queue(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/player/queue");
 		response.prettyPrint();
 		
	}
	@Test
	public void get_Request_Get_Recently_Played_Tracks(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/player/recently-played?limit=10&after=1484811043508");
 		response.prettyPrint();
 		
	}
	@Test
	public void get_Request_Get_Playback_State(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/player?market=ES");
 		response.prettyPrint();
 		
	}
	@Test
	public void get_Request_Get_Available_Devices(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/player/devices");
 		response.prettyPrint();
 		
	}
	@Test
	public void get_Request_Get_Currently_Playing_Track(){
    	Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.get("https://api.spotify.com/v1/me/player/currently-playing?market=ES");
 		response.prettyPrint();
 		
	}
	@Test
	public void post_Request_Skip_To_Next() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.post("https://api.spotify.com/v1/me/player/next?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void post_Request_Skip_To_Previous() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.post("https://api.spotify.com/v1/me/player/previous?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void post_Request_Add_Item_to_Playback_Queue() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.post("https://api.spotify.com/v1/me/player/queue?uri=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Pause_Playback() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/player/pause?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Start_Resume_Playback() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"context_uri\":\"spotify:album:5ht7ItJgpBH7W6vJ5BqpPr\",\"offset\":{\"position\":5},\"position_ms\":0}")
 				.when()
 				.put("https://api.spotify.com/v1/me/player/play?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Set_Repeat_Mode() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"context_uri\":\"spotify:album:5ht7ItJgpBH7W6vJ5BqpPr\",\"offset\":{\"position\":5},\"position_ms\":0}")
 				.when()
 				.put("https://api.spotify.com/v1/me/player/repeat?state=context&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Seek_To_Position() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"context_uri\":\"spotify:album:5ht7ItJgpBH7W6vJ5BqpPr\",\"offset\":{\"position\":5},\"position_ms\":0}")
 				.when()
 				.put("https://api.spotify.com/v1/me/player/seek?position_ms=25000&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Toggle_Playback_Shuffle() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.when()
 				.put("https://api.spotify.com/v1/me/player/shuffle?state=true&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Transfer_Playback() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"device_ids\":[\"74ASZWbe4lXaubB36ztrGX\"]}")
 				.when()
 				.put("https://api.spotify.com/v1/me/player");
 		response.prettyPrint();
	}
	@Test
	public void put_Request_Set_Playback_Volume() {
		Response response = given()
 				.header("Accept","application/json")
 				.header("Content-Type","application/json")
 				.header("Authorization",token)
 				.body("{\"device_ids\":[\"74ASZWbe4lXaubB36ztrGX\"]}")
 				.when()
 				.put("https://api.spotify.com/v1/me/player/volume?volume_percent=50&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
 		response.prettyPrint();
	}
	


}
