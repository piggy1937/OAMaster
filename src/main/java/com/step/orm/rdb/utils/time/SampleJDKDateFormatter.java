package com.step.orm.rdb.utils.time;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class SampleJDKDateFormatter implements DateFormatter {
    Predicate<String> predicate;
    Supplier<SimpleDateFormat> formatSupplier;

    public SampleJDKDateFormatter(Predicate<String> predicate, Supplier<SimpleDateFormat> formatSupplier) {
        this.predicate = predicate;
        this.formatSupplier = formatSupplier;
    }

    @Override
    public boolean support(String str) {
        return this.predicate.test(str);
    }

    @Override
    public Date format(String str) {
        try {
            return ((SimpleDateFormat)this.formatSupplier.get()).parse(str);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    @Override
    public String getPattern() {
        return ((SimpleDateFormat)this.formatSupplier.get()).toPattern();
    }

    @Override
    public String toString(Date date) {
        return (new DateTime(date)).toString(this.getPattern());
    }
}
