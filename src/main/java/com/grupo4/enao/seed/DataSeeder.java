package com.grupo4.enao.seed;

import com.grupo4.enao.model.Applicant;
import com.grupo4.enao.model.ApplicationData;
import com.grupo4.enao.model.ExamResult;
import com.grupo4.enao.model.Role;
import com.grupo4.enao.model.User;
import com.grupo4.enao.repository.ApplicantRepository;
import com.grupo4.enao.repository.ExamResultRepository;
import com.grupo4.enao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ApplicantRepository applicantRepository;
    private final ExamResultRepository examResultRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedUsers();
        seedDemoApplicant();
    }

    private void seedUsers() {
        if (userRepository.count() > 0) {
            return;
        }

        userRepository.save(User.builder()
                .username("admin")
                .passwordHash(passwordEncoder.encode("admin123"))
                .fullName("Administrador ASPEFO")
                .role(Role.ADMIN)
                .build());

        userRepository.save(User.builder()
                .username("maintainer")
                .passwordHash(passwordEncoder.encode("maintainer123"))
                .fullName("Mantenedor ENAO")
                .role(Role.MAINTAINER)
                .build());
    }

    private void seedDemoApplicant() {
        if (applicantRepository.count() > 0) {
            return;
        }

        Applicant demo = Applicant.builder()
                .fullName("JEAN PIERRE MENDOZA SALAR")
                .docType("DNI")
                .docNumber("72345678")
                .email("j.mendoza@unmsm.edu.pe")
                .phone("987654321")
                .emergencyContact("María Salar")
                .emergencyPhone("912345678")
                .address("Av. Universitaria 123, Lima")
                .passwordHash(passwordEncoder.encode("123456"))
                .applicationData(ApplicationData.builder()
                        .university("UNMSM - Universidad Nacional Mayor de San Marcos")
                        .internationalUniversity(false)
                        .organization(ApplicationData.SponsoringOrganization.MINSA)
                        .bank("Banco de la Nación")
                        .receiptCode("OP-98234123")
                        .status(ApplicationData.ApplicationStatus.VALIDATED)
                        .build())
                .build();

        demo = applicantRepository.save(demo);

        examResultRepository.save(ExamResult.builder()
                .applicant(demo)
                .score(85.5)
                .maximumScore(100.0)
                .status(ExamResult.Status.PUBLISHED)
                .build());
    }
}
