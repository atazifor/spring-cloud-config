package taz.amin.util.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ReactorTests {

    @Test
    void testFlux() {
        List<Integer> list = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .filter(x-> x % 2 == 0)
                .map(x -> x  * 2)
                .log()
                .subscribe(x -> list.add(x));
        assertThat(list).containsExactly(4, 8);
    }

    @Test
    void testFluxBlocking() {

        List<Integer> list = Flux.just(1, 2, 3, 4)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .log()
                .collectList().block();

        assertThat(list).containsExactly(4, 8);
    }
}
