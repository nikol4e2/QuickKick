package org.example.quickkick.service.impl;


import org.example.quickkick.model.Match;
import org.example.quickkick.model.PlayingMatch;
import org.example.quickkick.model.enums.MatchStatus;
import org.example.quickkick.model.exceptions.PlayingMatchNotFoundException;
import org.example.quickkick.repository.PlayingMatchRepository;
import org.example.quickkick.service.MatchService;
import org.example.quickkick.service.PlayingMatchService;
import org.springframework.stereotype.Service;

@Service
public class PlayingMatchServiceImpl  implements PlayingMatchService {

    private final PlayingMatchRepository playingMatchRepository;
    private final MatchService matchService;

    public PlayingMatchServiceImpl(PlayingMatchRepository playingMatchRepository, MatchService matchService) {
        this.playingMatchRepository = playingMatchRepository;
        this.matchService = matchService;
    }


    @Override
    public PlayingMatch findById(Long id) {
        return this.playingMatchRepository.findById(id).orElseThrow(PlayingMatchNotFoundException::new);
    }

    @Override
    public PlayingMatch save(Match match, int duration, int pauseTime, int timeoutTime) {
        PlayingMatch playingMatch=new PlayingMatch(match, duration, pauseTime, timeoutTime);
        return this.playingMatchRepository.save(playingMatch);
    }


    // TODO EDIT OR DELETE
    @Override
    public PlayingMatch update(PlayingMatch match) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(this.playingMatchRepository.existsById(id)) {
            this.playingMatchRepository.deleteById(id);
        }

    }

    @Override
    public void startMatch(Long playingMatchId) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            Match match=playingMatch.getMatch();
            match.setStatus(MatchStatus.PLAYING);
            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public void finishMatch(Long playingMatchId) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            Match match=playingMatch.getMatch();
            match.setStatus(MatchStatus.FINISH);
            matchService.finishMatch(match.getId());
            this.playingMatchRepository.save(playingMatch);
        }
    }
    //TODO Might need to delete this
    @Override
    public void startTimer(Long playingMatchId) {

    }

    @Override
    public void stopTimer(Long playingMatchId) {
    }


    @Override
    public void resetTimerToZero(Long playingMatchId) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            playingMatch.setTimer(playingMatch.getDuration());
            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public void startHalfTimeTimer(Long playingMatchId) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            playingMatch.setTimer(playingMatch.getPauseTime());
            playingMatch.setHalfTimeCounter(2);
            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public void addTimeToTimer(Long playingMatchId, int seconds) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            playingMatch.setTimer(playingMatch.getTimer()+seconds);

            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public void subtractTimeFromTimer(Long playingMatchId, int seconds) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            playingMatch.setTimer(playingMatch.getTimer()-seconds);
            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public void startTimeoutTimer(Long playingMatchId) {
        PlayingMatch playingMatch=this.findById(playingMatchId);
        if(playingMatch!=null) {
            playingMatch.setTimer(playingMatch.getTimeoutTime());
            this.playingMatchRepository.save(playingMatch);
        }
    }

    @Override
    public int getRemainingTime(Long playingMatchId) {
        PlayingMatch playingMatch=playingMatchRepository.findById(playingMatchId).orElseThrow(PlayingMatchNotFoundException::new);
        return playingMatch.getMinutesForPlayLeft();
    }
}
