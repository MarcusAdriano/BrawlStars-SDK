package io.github.marcusadriano.brawlstars.example;

import io.github.marcusadriano.brawlstars.BrawlStars;
import io.github.marcusadriano.brawlstars.model.Player;
import io.github.marcusadriano.brawlstars.model.Result;
import io.github.marcusadriano.brawlstars.service.BrawlStarsService;

import java.util.function.Function;

public class MainJavaExample {

    private static final Function<Result<Player>, String> printResult = result -> {
        if (result instanceof Result.Success) {
            Result.Success<Player> player = (Result.Success<Player>) result;
            return player.getData().getName() + " | trophies = " + player.getData().getTrophies();
        }

        Result.Error error = (Result.Error) result;
        return "Result.Error: " + error.getData().getReason();
    };

    public static void main(String[] args) {
        BrawlStars.setup(args[0]);
        BrawlStarsService service = BrawlStars.service();
        Result<Player> result = service.player("#9UV9UG9J");

        System.out.println(printResult.apply(result));
    }
}

