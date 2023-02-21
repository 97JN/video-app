package com.example.videoapp.api;

import com.example.videoapp.dao.entity.VideoCassette;
import com.example.videoapp.manager.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/cassetts/")
public class VideoCassetteApi {
    private VideoManager videoCassetteList;

    @Autowired
    public VideoCassetteApi(VideoManager videoCassetteList) {
        this.videoCassetteList = videoCassetteList;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassetteList.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
       return videoCassetteList.findById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette){
        return videoCassetteList.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo( @RequestBody VideoCassette videoCassette){
        return videoCassetteList.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo( @RequestParam Long index){
       videoCassetteList.delete(index);
    }
}
