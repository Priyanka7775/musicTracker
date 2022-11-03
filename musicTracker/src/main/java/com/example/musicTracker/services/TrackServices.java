package com.example.musicTracker.services;

import com.example.musicTracker.domain.Track;

import java.util.List;

public interface TrackServices {
    public Track addTrack(Track track);
    public List<Track> getAllTrack();
    public Track updateTrack(Track track,int trackId);
    public boolean deleteTrack(int trackId);
    public List<Track> getTrackbyTrackId(int trackId);
    public List<Track> getTrackbyTrackArtist(String trackArtist);
}
