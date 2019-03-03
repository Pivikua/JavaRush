package com.javarush.task.task33.task3309;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.ContentHandler;
import jdk.internal.org.xml.sax.Locator;
import jdk.internal.org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class MyContetnHandler implements ContentHandler   {

    XMLStreamWriter xsw;
    String tagName, comment;

    public MyContetnHandler(XMLStreamWriter xsw, String tagName, String comment) {
        this.xsw = xsw;
        this.tagName = tagName;
        this.comment = comment;
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        try {
            xsw.writeDTD("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String s, String s1) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String s) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(localName.equals(tagName)) {
            try {
                xsw.writeComment(comment);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
        try {
            xsw.writeStartElement("!--Komment--!");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        //xsw.writeAttribute(attributes, );
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        try {
            xsw.writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String data = new String(chars, start, length);
        if (data.matches(".*[<>&'\"].*")) {
            try {
                xsw.writeCData("![CDATA[need CDATA because of < and >]]");
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        } else {
            try {
                xsw.writeCharacters(tagName);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void ignorableWhitespace(char[] chars, int i, int i1) throws SAXException {

    }

    @Override
    public void processingInstruction(String s, String s1) throws SAXException {

    }

    @Override
    public void skippedEntity(String s) throws SAXException {

    }
}
