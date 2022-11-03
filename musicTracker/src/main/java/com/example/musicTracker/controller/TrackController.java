package com.example.musicTracker.controller;

import com.example.musicTracker.domain.Track;
import com.example.musicTracker.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackDetails/")
public class TrackController {
    private TrackServices trackServices;

    @Autowired
    public TrackController(TrackServices trackServices){
        this.trackServices=trackServices;
    }

    @PostMapping(value = "/track")
    public ResponseEntity<?> addTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackServices.addTrack(track), HttpStatus.CREATED);
    }

    @GetMapping(value = "/track1")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<>(trackServices.getAllTrack(),HttpStatus.OK);
    }

    @DeleteMapping(value="/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
        return new ResponseEntity<>(trackServices.deleteTrack(trackId),HttpStatus.OK);
    }

    @PutMapping(value = "/track/{trackId}")
    public ResponseEntity<?>updateTrack(@RequestBody Track track,@PathVariable int trackId){
        return new ResponseEntity<>(trackServices.updateTrack(track,trackId),HttpStatus.OK);
    }

    @GetMapping(value="/track1/{trackId}")
    public ResponseEntity<?>getTrackByTrackId(@PathVariable int trackId){
        return new ResponseEntity<>(trackServices.getTrackbyTrackId(trackId),HttpStatus.OK);
    }
    @GetMapping(value="/track2/{trackArtist}")
    public ResponseEntity<?>getTrackByTrackArtist(@PathVariable String trackArtist){
        return new ResponseEntity<>(trackServices.getTrackbyTrackArtist(trackArtist),HttpStatus.OK);
    }

}
