package com.bsassi.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.bsassi.hexagonal")
class ArchitectureNamingConventionTest {

    // ===================== Adapters IN =====================

    @ArchTest
    public static final ArchRule consumer_classes_should_be_in_consumer_package = classes()
            .that().haveSimpleNameEndingWith("Consumer")
            .should().resideInAPackage("com.bsassi.hexagonal.adapters.in.consumer")
            .because("Consumers handle inbound messages and must be placed in adapters.in.consumer for clarity and maintainability");

    @ArchTest
    public static final ArchRule classes_in_consumer_package_should_end_with_consumer = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.adapters.in.consumer")
            .should().haveSimpleNameEndingWith("Consumer")
            .because("Classes in consumer package represent message consumers and should follow naming convention for consistency");

    @ArchTest
    public static final ArchRule controller_classes_should_be_in_controller_package = classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("com.bsassi.hexagonal.adapters.in.controller")
            .because("Controllers expose inbound HTTP endpoints and must reside in adapters.in.controller");

    @ArchTest
    public static final ArchRule classes_in_controller_package_should_end_with_controller = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.adapters.in.controller")
            .should().haveSimpleNameEndingWith("Controller")
            .because("Classes in controller package should clearly indicate their role by ending with Controller");

    // ===================== Adapters OUT =====================

    @ArchTest
    public static final ArchRule repository_classes_should_be_in_repository_package = classes()
            .that().haveSimpleNameEndingWith("Repository")
            .should().resideInAPackage("com.bsassi.hexagonal.adapters.out.repository")
            .because("Repositories handle persistence and must reside in adapters.out.repository for proper separation of concerns");

    @ArchTest
    public static final ArchRule classes_in_repository_package_should_end_with_repository = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.adapters.out.repository")
            .should().haveSimpleNameEndingWith("Repository")
            .because("Classes in repository package should end with Repository to reflect their responsibility");

    @ArchTest
    public static final ArchRule client_classes_should_be_in_client_package = classes()
            .that().haveSimpleNameEndingWith("Client")
            .should().resideInAPackage("com.bsassi.hexagonal.adapters.out.client")
            .because("Clients integrate with external systems and must reside in adapters.out.client");

    @ArchTest
    public static final ArchRule classes_in_client_package_should_end_with_client = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.adapters.out.client")
            .should().haveSimpleNameEndingWith("Client")
            .because("Classes in client package should end with Client for clarity");

    // ===================== Application Layer =====================

    @ArchTest
    public static final ArchRule usecase_classes_should_be_in_usecase_package = classes()
            .that().haveSimpleNameEndingWith("UseCase")
            .should().resideInAPackage("com.bsassi.hexagonal.application.core.usecase")
            .because("UseCases implement business logic and must reside in application.core.usecase");

    @ArchTest
    public static final ArchRule classes_in_usecase_package_should_end_with_usecase = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.application.core.usecase")
            .should().haveSimpleNameEndingWith("UseCase")
            .because("Classes in usecase package should end with UseCase to indicate their role");

    @ArchTest
    public static final ArchRule input_port_classes_should_be_in_ports_in_package = classes()
            .that().haveSimpleNameEndingWith("InputPort")
            .should().resideInAPackage("com.bsassi.hexagonal.application.ports.in")
            .because("InputPort interfaces define inbound contracts and must reside in application.ports.in");

    @ArchTest
    public static final ArchRule output_port_classes_should_be_in_ports_out_package = classes()
            .that().haveSimpleNameEndingWith("OutputPort")
            .should().resideInAPackage("com.bsassi.hexagonal.application.ports.out")
            .because("OutputPort interfaces define outbound contracts and must reside in application.ports.out");

    @ArchTest
    public static final ArchRule classes_in_ports_in_package_should_end_with_inputport = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.application.ports.in")
            .should().haveSimpleNameEndingWith("InputPort")
            .because("Classes in ports.in package should end with InputPort for consistency");

    @ArchTest
    public static final ArchRule classes_in_ports_out_package_should_end_with_outputport = classes()
            .that().resideInAPackage("com.bsassi.hexagonal.application.ports.out")
            .should().haveSimpleNameEndingWith("OutputPort")
            .because("Classes in ports.out package should end with OutputPort for consistency");

    // ===================== Domain Layer =====================

    @ArchTest
    public static final ArchRule entity_classes_should_be_in_domain_packages = classes()
            .that().haveSimpleNameEndingWith("Entity")
            .should().resideInAnyPackage("com.bsassi.hexagonal.application.core.domain", "com.bsassi.hexagonal.adapters.out.repository.entity")
            .because("Entities represent core domain objects and must reside in domain packages");

    @ArchTest
    public static final ArchRule classes_in_domain_packages_should_end_with_entity = classes()
            .that().resideInAnyPackage("com.bsassi.hexagonal.application.core.domain", "com.bsassi.hexagonal.adapters.out.repository.entity")
            .should().haveSimpleNameEndingWith("Entity")
            .because("Classes in domain packages should end with Entity for clarity");

    // ===================== Shared Mapper =====================

    @ArchTest
    public static final ArchRule mapper_classes_should_be_in_mapper_packages = classes()
            .that().haveSimpleNameEndingWith("Mapper")
            .or().haveSimpleNameEndingWith("MapperImpl")
            .should().resideInAnyPackage(
                    "com.bsassi.hexagonal.adapters.in.controller.mapper",
                    "com.bsassi.hexagonal.adapters.in.consumer.mapper",
                    "com.bsassi.hexagonal.adapters.out.client.mapper",
                    "com.bsassi.hexagonal.adapters.out.repository.mapper"
            )
            .because("Mapper classes convert between layers and must reside in mapper packages");

    @ArchTest
    public static final ArchRule classes_in_mapper_packages_should_end_with_mapper = classes()
            .that().resideInAnyPackage(
                    "com.bsassi.hexagonal.adapters.in.controller.mapper",
                    "com.bsassi.hexagonal.adapters.in.consumer.mapper",
                    "com.bsassi.hexagonal.adapters.out.client.mapper",
                    "com.bsassi.hexagonal.adapters.out.repository.mapper"
            )
            .should().haveSimpleNameEndingWith("Mapper")
            .orShould().haveSimpleNameEndingWith("MapperImpl")
            .because("Classes in mapper packages should end with Mapper or MapperImpl for consistency");
}
