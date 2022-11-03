package com.example.musicTracker.services;

import com.example.musicTracker.domain.Track;
import com.example.musicTracker.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServicesImpl implements TrackServices{

    private TrackRepository trackRepository;
    public TrackServicesImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }
    @Override
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track, int trackId){
        Optional<Track> optrack=trackRepository.findById(trackId);
        if(optrack.isEmpty()){
            return null;
        }
        Track extistingtrack=optrack.get();
        if(track.getTrackName()!=null){
            extistingtrack.setTrackName(track.getTrackName());
        }
        if(track.getTrackArtist()!=null){
            extistingtrack.setTrackArtist(track.getTrackArtist());
        }if(track.getTrackComments()!=null){
            extistingtrack.setTrackComments(track.getTrackComments());
        }if(track.getTrackRating()!=-1){
            extistingtrack.setTrackRating(track.getTrackRating());
        }
        return trackRepository.save(extistingtrack);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> getTrackbyTrackId(int trackId) {
     return trackRepository.findByTrackId(trackId);
    }

    @Override
    public List<Track> getTrackbyTrackArtist(String trackArtist) {
        return trackRepository.findByTrackArtist(trackArtist);
    }
}
