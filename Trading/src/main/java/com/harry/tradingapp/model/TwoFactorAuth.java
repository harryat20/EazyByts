package com.harry.tradingapp.model;

import com.harry.tradingapp.domain.VerificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;


}
