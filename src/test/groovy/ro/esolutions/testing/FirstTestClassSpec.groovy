package ro.esolutions.testing

import spock.lang.Specification
import spock.lang.Unroll

import javax.swing.Renderer


class FirstTestClassSpec extends Specification {


    def "first test for demo with expected"() {
        expect:
        1 == 1
    }

    def "second test with given-when-then"() {
        given:
        def polygon = new Polygon(4)
        def expectedResult = 4

        when:
        def sides = polygon.numberOfSides

        then:
        sides == expectedResult
    }

    def "should throw exception if number of sides: #sides"() {
        when:
        new Polygon(sides)

        then:
        def exception = thrown(RuntimeException)
        exception.message == "you need to have more than 2 side for a polygon"

        where:
        sides << [-1, 0, 1, 2]
    }

    def "test polygon for number of sides: #sides"() {
        given:
        def polygon = new Polygon(sides)

        when:
        def result = polygon.numberOfSides

        then:
        result == sides

        where:
        sides << [3, 4, 5, 1000]
    }

    def "tes with data tables, Min a: #a, b: #b, min: #min"() {
        expect:
        Math.min(a, b) == min

        where:
        a  | b || min
        1  | 2 || 1
        5  | 3 || 3
        -1 | 2 || -1
        0  | 0 || 0
    }

    def "should be able to mock a concrete class"() {
        given:
        def renderer = Mock(Renderer)
    }
}
