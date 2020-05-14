package com.example.music.dao;

import com.example.music.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music,Integer> {

}
