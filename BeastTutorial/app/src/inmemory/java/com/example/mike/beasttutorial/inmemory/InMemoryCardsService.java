package com.example.mike.beasttutorial.inmemory;

import com.example.mike.beasttutorial.entities.EventCard;
import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.example.mike.beasttutorial.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Mike on 4/13/2017.
 */

public class InMemoryCardsService extends BaseInMemory{
    public InMemoryCardsService(BeastApplication beastApplication) {
        super(beastApplication);
    }


    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunitySericeCardRequest request)
    {
        EventCardService.SearchCommunityServiceCardsResponse responce = new EventCardService.SearchCommunityServiceCardsResponse();
        responce.communityServiceCards = new ArrayList<>();
        responce.communityServiceCards.add(new EventCard(
                1,
                "Community Event 1",
                "Community Event 1's Description",
                "http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
                false,
                "null"
        ));

        responce.communityServiceCards.add(new EventCard(
                1,
                "Community Event 2",
                "Community Event 2's Description",
                "http://www.gravatar.com/avatar/" + 2 + "?d=identicon",
                false,
                "null"
        ));

        bus.post(responce);
    }

    @Subscribe
    public void searchBrotherhoodCards(EventCardService.SearchBrotherhoodCardCardRequest request)
    {
        EventCardService.SearchBrotherhoodCardCardResponce responce = new EventCardService.SearchBrotherhoodCardCardResponce();
        responce.brotherhooodCards = new ArrayList<>();
        responce.brotherhooodCards.add(new EventCard(
                3,
                "Brotherhood Event 1",
                "Brotherhood Event 1's Description",
                "http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
                false,
                "null"
        ));

        responce.brotherhooodCards.add(new EventCard(
                4,
                "Brotherhood Event 2",
                "Brotherhood Event 2's Description",
                "http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
                true,
                "null"
        ));

        bus.post(responce);
    }

    @Subscribe
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request)
    {
        EventCardService.SearchSocialCardResponce responce = new EventCardService.SearchSocialCardResponce();
        responce.socialCards = new ArrayList<>();
        responce.socialCards.add(new EventCard(
                5,
                "Social Event 1",
                "Social Event 1's Description",
                "http://www.gravatar.com/avatar/" + 5 + "?d=identicon",
                false,
                "null"
        ));

        responce.socialCards.add(new EventCard(
                6,
                "Social Event 2",
                "Social Event 2's Description",
                "http://www.gravatar.com/avatar/" + 6 + "?d=identicon",
                true,
                "null"
        ));

        bus.post(responce);
    }

}
