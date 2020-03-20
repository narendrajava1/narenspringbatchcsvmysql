package com.naren.batch.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.naren.batch.dao.entity.Voltage;

import java.math.BigDecimal;

public class VoltageProcessor implements ItemProcessor<Voltage, Voltage>{

    @Override
    public Voltage process(final Voltage voltage) {
        final BigDecimal volt = voltage.getVolt();
        final double time = voltage.getTime();

        final Voltage processedVoltage = new Voltage();
        processedVoltage.setVolt(volt);
        processedVoltage.setTime(time);
        return processedVoltage;
    }
}
