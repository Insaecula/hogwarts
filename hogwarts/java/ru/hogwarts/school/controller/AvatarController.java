package ru.hogwarts.school.controller;

import ru.hogwarts.school.repositories.AvatarRepository;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/avatars")
public class AvatarController {

    private final AvatarRepository avatarRepository;

    public AvatarController(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    @GetMapping
    public Page<Avatar> getAvatarsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return avatarRepository.findAll(pageable);
    }
}
