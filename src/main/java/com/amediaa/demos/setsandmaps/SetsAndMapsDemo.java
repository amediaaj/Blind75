package com.amediaa.demos.setsandmaps;

import com.amediaa.common.Demo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsAndMapsDemo implements Demo {



    @Override
    public void execute() {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "Rhood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A \u222A B) Union of emails (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersection of emails (A) with phones (B)", intersectAB);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) minus phones (B)", AMinusB);

        // Set symetric difference, either add AminusB to BminusA,
        // or subtraction the intersection of A and B from the union of A and B

    }

    public void printData(String header, Collection<Contact> contacts) {
        System.out.println("----------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------");
        contacts.forEach(System.out::println);
    }
}
