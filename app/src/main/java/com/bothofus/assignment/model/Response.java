package com.bothofus.assignment.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Response {


    @SerializedName("countries")
    @Expose
    private ArrayList<Country> countries = new ArrayList<>();

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setSubjects(ArrayList<Country> countries) {
        this.countries = countries;
    }


    @Override
    public String toString() {
        return "Response{" +
                "countries=" + countries +
                '}';
    }

    public class Country
    {
        @SerializedName("id")
        @Expose
        int id;

        @SerializedName("name")
        @Expose
        String name;

        @SerializedName("emission")
        @Expose
        float emission;

        @Override
        public String toString() {
            return "Country{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", emission=" + emission +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getEmission() {
            return emission;
        }

        public void setEmission(float emission) {
            this.emission = emission;
        }
    }

}

