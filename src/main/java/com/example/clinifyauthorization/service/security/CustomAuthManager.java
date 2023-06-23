//package com.example.clinifyauthorization.service.security;
//
//import com.example.clinifyauthorization.persistence.entity.Patient;
//import com.example.clinifyauthorization.service.security.user.clinic.ClinicUserDetailsService;
//import com.example.clinifyauthorization.service.security.user.patient.PatientUserDetailsService;
//import org.apache.commons.logging.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.log.LogMessage;
//import org.springframework.security.authentication.*;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.stereotype.Service;
//
//import java.util.Iterator;
//
//@Service
//public class CustomAuthManager extends ProviderManager {
//    @Autowired
//    private ClinicUserDetailsService clinicUserDetailsService;
//    @Autowired
//    private PatientUserDetailsService patientUserDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        Class<? extends Authentication> toTest = authentication.getClass();
//        AuthenticationException lastException = null;
//        AuthenticationException parentException = null;
//        Authentication result = null;
//        Authentication parentResult = null;
//
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//
//        if (authenticationProvider.supports(toTest)) {
//
//            try {
//                authenticationProvider = new DaoAuthenticationProvider();
//                authenticationProvider.setUserDetailsService(clinicUserDetailsService);
//
//                result = authenticationProvider.authenticate(authentication);
//                if (result != null) {
//                    this.copyDetails(authentication, result);
//                }
//            } catch ( Exception ex) {
//                try {
//                    authenticationProvider = new DaoAuthenticationProvider();
//                    authenticationProvider.setUserDetailsService(patientUserDetailsService);
//
//                    result = authenticationProvider.authenticate(authentication);
//                    if (result != null) {
//                        this.copyDetails(authentication, result);
//                    }
//                } catch (InternalAuthenticationServiceException | AccountStatusException var14) {
////                        this.prepareException(var14, authentication);
//                    throw var14;
//                } catch (AuthenticationException var15) {
//                    lastException = var15;
//                }
//            }
//        }
//        return result;
//
//
////        if (result == null && this.parent != null) {
////            try {
////                parentResult = this.parent.authenticate(authentication);
////                result = parentResult;
////            } catch (ProviderNotFoundException var12) {
////            } catch (AuthenticationException var13) {
////                parentException = var13;
////                lastException = var13;
////            }
////        }
////
////        if (result != null) {
////            if (this.eraseCredentialsAfterAuthentication && result instanceof CredentialsContainer) {
////                ((CredentialsContainer)result).eraseCredentials();
////            }
////
////            if (parentResult == null) {
////                this.eventPublisher.publishAuthenticationSuccess(result);
////            }
////
////            return result;
////        } else {
////            if (lastException == null) {
////                lastException = new ProviderNotFoundException(this.messages.getMessage("ProviderManager.providerNotFound", new Object[]{toTest.getName()}, "No AuthenticationProvider found for {0}"));
////            }
////
////            if (parentException == null) {
////                this.prepareException((AuthenticationException)lastException, authentication);
////            }
////
////            throw lastException;
////        }
//    }
//
//    private void copyDetails(Authentication source, Authentication dest) {
//        if (dest instanceof AbstractAuthenticationToken token && dest.getDetails() == null) {
//            token.setDetails(source.getDetails());
//        }
//    }
//}
