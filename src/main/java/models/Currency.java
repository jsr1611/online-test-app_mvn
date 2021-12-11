package models;

import lombok.Data;

@Data
public class Currency {
    private Long id;
    private String Code;
    private String Ccy;
    private String CcyNm_RU;
    private String CcyNm_UZ;
    private String CcyNm_UZC;
    private String CcyNm_EN;
    private String Nominal;
    private String Rate;
    private String Diff;
    private String Date;

    /*
<id> – Тартиб рақами;
<Code> – Валютанинг сонли коди. Масалан: 840, 978, 643 ва бошқалар;
<Ccy> – Валютанинг рамзли коди (альфа-3). Масалан: USD, EUR, RUB ва бошқалар;
<CcyNm_RU> – Валютанинг рус тилидаги номи;
<CcyNm_UZ> – Валютанинг ўзбек (лотин) тилидаги номи;
<CcyNm_UZC> – Валютанинг ўзбек (кириллица) тилидаги номи;
<CcyNm_EN> – Валютанинг инглиз тилидаги номи;
<Nominal> – Валютанинг бирликлар сони;
<Rate> – Валюта курси;
<Diff> – Валютлар курслари фарқи;
<Date> – Курснинг амал қилиш санаси.
 */
}
