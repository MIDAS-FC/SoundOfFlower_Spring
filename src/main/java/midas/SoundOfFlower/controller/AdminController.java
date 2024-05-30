package midas.SoundOfFlower.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import midas.SoundOfFlower.dto.request.AdminUserRequest;
import midas.SoundOfFlower.dto.request.PlayListRequest;
import midas.SoundOfFlower.service.AuthService;
import midas.SoundOfFlower.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AuthService authService;
    private final MusicService musicService;

    @PostMapping("/auth/admin/register")
    public ResponseEntity<Object> signup(@Valid @RequestBody AdminUserRequest adminUserRequest) {

        authService.adminSignUp(adminUserRequest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/music")
    public ResponseEntity<Object> playlist(@RequestBody PlayListRequest playListRequest) {

        musicService.sendPlaylist(playListRequest.getPlaylist());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
