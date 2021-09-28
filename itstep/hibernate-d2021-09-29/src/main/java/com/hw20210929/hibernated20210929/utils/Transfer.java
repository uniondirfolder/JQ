package com.hw20210929.hibernated20210929.utils;

import com.hw20210929.hibernated20210929.Dto;
import com.hw20210929.hibernated20210929.Note;

public class Transfer {
    public static Dto fromNote(Note note){
        return new Dto(note.getId(), note.getDate(), note.getBody());
    }
    public static Note fromNote(Dto dto){
        return new Note(dto.getId(), dto.getDate(), dto.getDisc());
    }
}
