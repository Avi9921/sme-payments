package com.credmarg.smepayments.service;

import com.credmarg.smepayments.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VendorService {
    private final List<Vendor> vendors = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    public Vendor addVendor(Vendor vendor) {
        vendor.setId(counter.incrementAndGet());
        vendors.add(vendor);

        return vendor;
    }

    public List<Vendor> getAllVendors() {
        return new ArrayList<>(vendors);
    }

}
