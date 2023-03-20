package com.example.mixedconcretedesign


public enum class GradeOfConcrete(val position : Int){
    M10(0), M15(1),M20(2),M25(3),M30(4),
    M35(5),M40(6),M45(7),M50(8),M55(9),M60(10)


}
enum class EXPOSURECONDITION(val value : Int){
    MILD(0), MODERATE(1),SEVERE(2),VERYSEVERE(3),EXTREME(4)
}
enum class WORKABLITY(val value : Int){
    V10(0), V15(1),V20(2),V25(3),V30(4),V35(5),
    V40(6),V45(7),V50(8),V55(8),V60(9),V65(9),
    V70(10),V75(11),V80(12),V85(13),V90(14),V95(15),
    V100(16),V105(17),V110(18),V115(18),V120(19),V125(20),
    V130(21),V135(22),V140(23),V145(24),V150(25),V155(26),
    V160(27),V165(28),V170(29),V175(30),V180(31),V185(32),
    V190(33),V195(34),V200(35)

}
enum class MAXIMUMNOMINAL(val value : Int) {
    V10(0), V20(1), V30(2), V40(3)
}
enum class TYPEOFCONCRETE(val value : Int) {
    PLAINCONCRETE(0), REINFORCED(1)
}
enum class TYPEOFCEMENT(val value : Int) {
    PPC(0), OPC43(1)
}
enum class SITECONTROL(val value : Int) {
    GOOD(0), FAIR(1)
}

enum class METHODOFPLACING(val value : Int) {
    NOPUMPING(0), PUMPING(1)
}

enum class SIZEOFAGGREGATE(val value : Int) {
    V10(0), V20(1),V40(2)
}
enum class TYPEOFAGGREGATE(val value : Int) {
    CRUSHEDANGULAR(0), SUBANGULAR(1),GRAVELANDCRUSED(2),REMOULDGRAVEL(3)
}

enum class ZONEOFAGGRE(val value : Int) {
    ZONE1(0), ZONE2(1),ZONE3(2),ZONE4(3)
}

enum class AGGREGATECONDITION(val value : Int) {
    SSD(0), DRYORWET(1)
}
enum class TYPEOFMINERALADMIXTURE(val value : Int) {
    FLYASH(0), GGBS(1),SILICAFUME(2),METAKAOLINE(3),MAXIMAPLAST(4)
    ,RICEHUSK(5)
}


