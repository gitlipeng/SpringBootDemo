package com.example.demo.gh;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseDate {
    public static List<P310> p310List = new ArrayList<>();
    public static List<P311> p311List = new ArrayList<>();
    public static final BigDecimal P1 = new BigDecimal("0.461526");
    public static final double P2 = 0.461526;

    static {
        p310List.add(new P310(0	,	-9.69276865	));
        p310List.add(new P310(1	,	10.08665597	));
        p310List.add(new P310(-5	,	-0.005608791	));
        p310List.add(new P310(-4	,	0.071452738	));
        p310List.add(new P310(-3	,	-0.407104982	));
        p310List.add(new P310(-2	,	1.424081917	));
        p310List.add(new P310(-1	,	-4.383951132	));
        p310List.add(new P310(2	,	-0.284086325	));
        p310List.add(new P310(3	,	0.021268464	));

        p311List.add(new P311(1	,	0	,	-0.001773174	));
        p311List.add(new P311(1	,	1	,	-0.017834862	));
        p311List.add(new P311(1	,	2	,	-0.045996014	));
        p311List.add(new P311(1	,	3	,	-0.057581259	));
        p311List.add(new P311(1	,	6	,	-0.050325279	));
        p311List.add(new P311(2	,	1	,	-3.30326E-05	));
        p311List.add(new P311(2	,	2	,	-0.00018949	));
        p311List.add(new P311(2	,	4	,	-0.003939278	));
        p311List.add(new P311(2	,	7	,	-0.043797296	));
        p311List.add(new P311(2	,	36	,	-2.66745E-05	));
        p311List.add(new P311(3	,	0	,	2.04817E-08	));
        p311List.add(new P311(3	,	1	,	4.38707E-07	));
        p311List.add(new P311(3	,	3	,	-3.22777E-05	));
        p311List.add(new P311(3	,	6	,	-0.001503392	));
        p311List.add(new P311(3	,	35	,	-0.040668254	));
        p311List.add(new P311(4	,	1	,	-7.88473E-10	));
        p311List.add(new P311(4	,	2	,	1.27907E-08	));
        p311List.add(new P311(4	,	3	,	4.82254E-07	));
        p311List.add(new P311(5	,	7	,	2.29221E-06	));
        p311List.add(new P311(6	,	3	,	-1.67148E-11	));
        p311List.add(new P311(6	,	16	,	-0.002117147	));
        p311List.add(new P311(6	,	35	,	-23.89574193	));
        p311List.add(new P311(7	,	0	,	-5.90596E-18	));
        p311List.add(new P311(7	,	11	,	-1.26218E-06	));
        p311List.add(new P311(7	,	25	,	-0.038946842	));
        p311List.add(new P311(8	,	8	,	1.12562E-11	));
        p311List.add(new P311(8	,	36	,	-8.23113409	));
        p311List.add(new P311(9	,	13	,	1.98097E-08	));
        p311List.add(new P311(10	,	4	,	1.0407E-19	));
        p311List.add(new P311(10	,	10	,	-1.02347E-13	));
        p311List.add(new P311(10	,	14	,	-1.00182E-09	));
        p311List.add(new P311(16	,	29	,	-8.08829E-11	));
        p311List.add(new P311(16	,	50	,	0.106930319	));
        p311List.add(new P311(18	,	57	,	-0.336622506	));
        p311List.add(new P311(20	,	20	,	8.91858E-25	));
        p311List.add(new P311(20	,	35	,	3.06293E-13	));
        p311List.add(new P311(20	,	48	,	-4.20025E-06	));
        p311List.add(new P311(21	,	21	,	-5.9056E-26	));
        p311List.add(new P311(22	,	53	,	3.78269E-06	));
        p311List.add(new P311(23	,	39	,	-1.27686E-15	));
        p311List.add(new P311(24	,	26	,	7.30876E-29	));
        p311List.add(new P311(24	,	40	,	5.54147E-17	));
        p311List.add(new P311(24	,	58	,	-9.43697E-07	));
    }
}
