package models;

import lombok.Data;

@Data
public class Currency {
    /**
     * <id> – Тартиб рақами;
     */
    private Long id;

    /**
     * <Code> – Валютанинг сонли коди. Масалан: 840, 978, 643 ва бошқалар;
     */
    private String Code;

    /**
     * <Ccy> – Валютанинг рамзли коди (альфа-3). Масалан: USD, EUR, RUB ва бошқалар;
     */
    private String Ccy;

    /**
     * <CcyNm_RU> – Валютанинг рус тилидаги номи;
     */
    private String CcyNm_RU;

    /**
     * <CcyNm_UZ> – Валютанинг ўзбек (лотин) тилидаги номи;
     */
    private String CcyNm_UZ;

    /**
     * <CcyNm_UZC> – Валютанинг ўзбек (кириллица) тилидаги номи;
     */
    private String CcyNm_UZC;

    /**
     * <CcyNm_EN> – Валютанинг инглиз тилидаги номи;
     */
    private String CcyNm_EN;

    /**
     * <Nominal> – Валютанинг бирликлар сони;
     */
    private String Nominal;

    /**
     * <Rate> – Валюта курси;
     */
    private String Rate;

    /**
     * <Diff> – Валютлар курслари фарқи;
     */
    private String Diff;

    /**
     * <Date> – Курснинг амал қилиш санаси.
     */
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
