package com.example.videoapp.manager;

import com.example.videoapp.dao.VideoRepo;
import com.example.videoapp.dao.entity.VideoCassette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

@Service
public class VideoManager {
    private VideoRepo videoRepo;

    @Autowired
    public VideoManager(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoRepo.save(videoCassette);
    }

    public void delete(Long id) {
        videoRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "Titanic", LocalDate.of(1997, 1, 2)));
        save(new VideoCassette(2L, "Power Rangers", LocalDate.of(1995, 2, 6)));
    }
}
