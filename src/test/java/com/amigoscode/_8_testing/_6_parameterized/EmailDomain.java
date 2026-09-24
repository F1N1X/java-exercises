package com.amigoscode._8_testing._6_parameterized;

enum EmailDomain { GMAIL("gmail.com"), YAHOO("yahoo.com"), OUTLOOK("outlook.com");
final String domain;
EmailDomain(String d) { this.domain = d; }
}