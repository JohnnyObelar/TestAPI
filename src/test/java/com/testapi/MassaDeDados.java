package com.testapi;

public class MassaDeDados {
    String vote_id;
    String urlcadastro = "user/passwordlesssignup";
    String corpocadastro = "{\"email\" : \"johnnym@ciandt.com\", \"appDescription\" : \"test the cat api\"}";
    String urlvotacao = "votes";
    String corpovotacao = "{\"image_id\" : \"z7lsAHzkV\", \"value\" : \"true\", \"sub_id\": \"demo-c26f9f\"}";
    String urlfavoritar = "favourites";
    String corpofavoritar = "{\"image_id\": \"z7lsAHzkV\", \"sub_id\": \"demo-766126\"}";
    String urldesfavoritar = "favourites/{favourite_id}";
}
