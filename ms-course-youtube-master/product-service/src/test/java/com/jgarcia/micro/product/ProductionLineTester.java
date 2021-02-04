package com.jgarcia.micro.product;

import com.jgarcia.micro.product.entity.Product;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProductionLineTester {

    // verifier service --
    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    /**
     * filter allowed products and then check exceptions
     * - Exception
     * - Runtime
     * - All
     */
    ProductLineTestReport test(Stream<Product> products) {

        ProductLineTestReport result = new ProductLineTestReport();
        // get the list of products filtered as requested
        Set<Product> productSetFiltered = products
                .filter(Objects::nonNull)
                .filter(p -> !p.getStatus().equalsIgnoreCase("invalid"))
                .skip(10)
                .limit(20)
                .collect(Collectors.toSet());

        // process each product verifying its correctness
        productSetFiltered.stream().forEach(product -> {
            try {

                verifier.verify(product);
                result.correctCnt++;
            } catch (RuntimeException run) {
                result.uncheckedExcCnt++;
            } catch (Exception e) {
                result.checkedExcCnt++;
            } catch (Throwable th) {
                result.otherExcCnt++;
            }
        });

        return result;
    }

}