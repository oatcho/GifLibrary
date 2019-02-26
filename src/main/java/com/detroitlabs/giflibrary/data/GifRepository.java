package com.detroitlabs.giflibrary.data;

import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.stereotype.Component;

import java.security.AllPermission;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("toobad", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 1),
            new Gif("exhausting", LocalDate.of(2019, 2, 23), "Jen Bloomer", false, 2),
            new Gif("headtilt", LocalDate.of(2019, 2, 23), "Dan Newport", true, 3),
            new Gif("corgibeg", LocalDate.of(2019, 2, 23), "Matt of Lansing", false, 3),
            new Gif("hugemistake", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 2),
            new Gif("whatisaid", LocalDate.of(2019, 2, 23), "Dan Newport", true, 2)
    );

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name){
        for (Gif gif: ALL_GIFS){
            if (gif.getName().equalsIgnoreCase(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> searchResult(String userInput){
        List<Gif> gifsPertainingToSearch = new ArrayList<>();

        for (Gif gif: ALL_GIFS){
            if(gif.getName().contains(userInput)){
                gifsPertainingToSearch.add(gif);
            }
        }
        return gifsPertainingToSearch;
    }

    public List<Gif> findByCategory(int id){

        List<Gif> gifsInCategory = new ArrayList<>();

        for (Gif gif: ALL_GIFS){
            if(gif.getId() == id){
                gifsInCategory.add(gif);
            }
        }
        return gifsInCategory;
    }
}
