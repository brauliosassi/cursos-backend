package com.bsassi.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.bsassi.hexagonal")
public class NamingCoventionTest {

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .as("Consumer classes reside inside consumer package in adapters.in package");


    public static final ArchRule mapper_reside_only_mapper_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("adapters.in.consumer.mapper", "..adapters.in.controller.mapper", "..adapter.out.client.mapper", "..adapters.out.repository.mapper")
            .as("Mapper classes should reside inside package in controller, client, consumer or repository");

    @ArchTest
    public static final ArchRule controller_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.controller")
            .as("Controller classes must reside inside adapters.in.controller package");

    // ===================== Adapters OUT =====================

    @ArchTest
    public static final ArchRule repository_reside_only_repository_package = classes()
            .that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAPackage("..adapters.out.repository")
            .as("Repository classes must reside inside adapters.out.repository package");

    @ArchTest
    public static final ArchRule client_reside_only_client_package = classes()
            .that()
            .haveNameMatching(".*Client")
            .should()
            .resideInAPackage("..adapters.out.client")
            .as("Client classes must reside inside adapters.out.client package");

    // ===================== Application Layer =====================

    @ArchTest
    public static final ArchRule service_reside_only_service_package = classes()
            .that()
            .haveNameMatching(".*Service")
            .should()
            .resideInAPackage("..application.service")
            .as("Service classes must reside inside application.service package");

    @ArchTest
    public static final ArchRule usecase_reside_only_port_in_package = classes()
            .that()
            .haveNameMatching(".*UseCase")
            .should()
            .resideInAPackage("..application.port.in")
            .as("UseCase classes must reside inside application.port.in package");

    @ArchTest
    public static final ArchRule port_reside_only_port_out_package = classes()
            .that()
            .haveNameMatching(".*Port")
            .should()
            .resideInAPackage("..application.port.out")
            .as("Port classes must reside inside application.port.out package");

    // ===================== Domain Layer =====================

    @ArchTest
    public static final ArchRule entity_reside_only_domain_model_package = classes()
            .that()
            .haveNameMatching(".*Entity")
            .should()
            .resideInAPackage("..domain.model")
            .as("Entity classes must reside inside domain.model package");

    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAnyPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");
}
