//package com.example.clinifyauthorization.service.security.client;
//
//import com.example.clinifyauthorization.persistence.reposatory.ClinicRepository;
//import com.example.clinifyauthorization.persistence.reposatory.PatientRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class CustomClientService implements RegisteredClientRepository {
//    private PatientRepository patientRepository;
//    private ClinicRepository clinicRepository;
//
//    public CustomClientService (PatientRepository patientRepository, ClinicRepository clinicRepository){
//        this.patientRepository = patientRepository;
//        this.clinicRepository = clinicRepository;
//    }
//    @Override
//    public void save(RegisteredClient registeredClient) {
//        patientRepository.save(Client.from(registeredClient));
//    }
//
//    @Override
//    public RegisteredClient findById(String id) {
//        var client =
//                patientRepository.findById(Integer.valueOf(id))
//                        .orElseThrow();
//        return Client.from(client);
//    }
//
//    @Override
//    public RegisteredClient findByClientId(String clientId) {
//        var client =
//                patientRepository.findByEmailIgnoreCase(clientId)
//                        .orElseThrow();
//        return Client.from(client);
//    }
//}
