package com.testapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class TestAPI extends MassaDeDados {

    @BeforeClass
    public static void urlBase(){
        RestAssured.baseURI = "https://api.thecatapi.com/v1/";

    }

    @Test
    public void cadastro() {
        Response response = given().contentType("application/json").body(corpocadastro).
        when().post(urlcadastro);
        validacao(response);
    }


    public void votacao() {
        Response response = given().contentType("application/json").body(corpovotacao)
                .header("x-api-key", "47a3f313-7107-4c3f-9213-3f9ff872874b")
                .when().post(urlvotacao);
        validacao(response);
        String id = response.jsonPath().getString("id");
        vote_id = id;
        System.out.println("ID =>" + id);
    }


    public void deletavotacao() {
        Response response = given().contentType("application/json")
                .header("x-api-key", "47a3f313-7107-4c3f-9213-3f9ff872874b")
                        .pathParam("vote_id", vote_id)
                        .when().delete("votes/{vote_id}");
        validacao(response);
    }

    @Test
    public void metododeletaevotacao(){
        votacao();
        deletavotacao();
    }


    public void favoritar() {
        Response response = given().contentType("application/json")
                .header("x-api-key", "47a3f313-7107-4c3f-9213-3f9ff872874b")
                .body(corpofavoritar).
                when().post(urlfavoritar);
        response.then().statusCode(200);
        String id = response.jsonPath().getString("id");
        vote_id = id;
        System.out.println("ID =>" + id);
        System.out.println("Retorno favorita =>" + response.body().asString());
        validacao(response);
    }


    public void desfavoritar() {
        Response response = given().contentType("application/json")
                .header("x-api-key", "47a3f313-7107-4c3f-9213-3f9ff872874b")
                .pathParam("favourite_id", vote_id)
                .when().delete(urldesfavoritar);
        response.then().statusCode(200);
        System.out.println("Retorno desfavorita =>" + response.body().asString());
        System.out.println("ID DESFAVORITA =>" + vote_id);
        validacao(response);
    }

    @Test
    public void metododeleteefavoritar(){
        favoritar();
        desfavoritar();
    }


    public void validacao(Response response){
        response.then().body(containsString("SUCCESS")).statusCode(200);
        System.out.println("Retorno =>" + response.body().asString());
        System.out.println("-----------------------------------------");
    }



}
