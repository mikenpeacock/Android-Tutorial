package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.entities.EventPicture;
import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.example.mike.beasttutorial.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 4/15/2017.
 */

public class InMemoryPictureService extends BaseInMemory {
    public InMemoryPictureService(BeastApplication beastApplication) {
        super(beastApplication);
    }

    @Subscribe
    public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoRequest request)
    {
        EventPhotoService.SearchCommunityPhotoResponse response = new EventPhotoService.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();

        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 44 + "?d=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 23 + "?d=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 11 + "?d=identicon"));
        bus.post(response);
    }

    @Subscribe
    public void getBrotherhoodPhotos(EventPhotoService.SearchBrotherhoodPhotoRequest request)
    {
        EventPhotoService.SearchBotherhoodPhotoResponse response = new EventPhotoService.SearchBotherhoodPhotoResponse();
        response.brotherhoodPhotos = new ArrayList<>();

        response.brotherhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 1 + "?d=identicon"));
        response.brotherhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 4 + "?d=identicon"));
        response.brotherhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 77 + "?d=identicon"));
        bus.post(response);
    }

    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotoRequest request)
    {
        EventPhotoService.SearchSocialPhotoResponse response = new EventPhotoService.SearchSocialPhotoResponse();
        response.socialPhotos = new ArrayList<>();

        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 65 + "?d=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 64 + "?d=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 63 + "?d=identicon"));
        bus.post(response);
    }


}
