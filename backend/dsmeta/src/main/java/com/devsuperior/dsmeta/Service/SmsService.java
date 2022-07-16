package com.devsuperior.dsmeta.Service;

import com.devsuperior.dsmeta.Model.SalesModel;
import com.devsuperior.dsmeta.Repository.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

        @Value("${twilio.sid}")
        private String twilioSid;

        @Value("${twilio.key}")
        private String twilioKey;

        @Value("${twilio.phone.from}")
        private String twilioPhoneFrom;

        @Value("${twilio.phone.to}")
        private String twilioPhoneTo;

        @Autowired
        private SalesRepository salesRepository;

        public void sendSms(Long saleid) {

           SalesModel sale = salesRepository.findById(saleid).get();

           String msg = "Vendedor "+ sale.getSellerName() + " realizou uma venda de " + sale.getAmount() + " R$ no dia " + sale.getDate()+".";

            Twilio.init(twilioSid, twilioKey);

            PhoneNumber to = new PhoneNumber(twilioPhoneTo);
            PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

            Message message = Message.creator(to, from, msg).create();

            System.out.println(message.getSid());
        }
}