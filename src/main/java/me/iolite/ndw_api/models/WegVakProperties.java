package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WegVakProperties {
    private Integer wvk_id;
    private String wvk_begdat;
    private long jte_id_beg;
    private long jte_id_end;
    private String wegbehsrt;
    private String wegnummer;
    private String wegdeelltr;
    private String hecto_lttr;
    private String bst_code;
    private String rpe_code;
    private String admrichtng;
    private String rijrichtng;
    private String stt_naam;
    private String stt_bron;
    private String wpsnaam;
    private int gme_id;
    private String gme_naam;
    private String hnrstrlnks;
    private String hnrstrrhts;
    private int e_hnr_lnks;
    private int e_hnr_rhts;
    private int l_hnr_lnks;
    private int l_hnr_rhts;
    private Double begafstand;
    private Double endafstand;
    private Double beginkm;
    private Double eindkm;
    private String pos_tv_wol;
    private String wegbehcode;
    private String wegbehnaam;
    private int distrcode;
    private String distrnaam;
    private String dienstcode;
    private String dienstnaam;
    private String wegtype;
    private String wgtype_oms;
    private String routeltr;
    private Integer routenr;
    private String routeltr2;
    private Integer routenr2;
    private String routeltr3;
    private Integer routenr3;
    private String routeltr4;
    private Integer routenr4;
    private String wegnr_aw;
    private String wegnr_hmp;
    private int geobron_id;
    private String geobron_nm;
    private int bronjaar;
    private String openlr;
    private String bag_orl;
    private String frc;
    private String fow;
    private String alt_naam;
    private String alt_nr;
    private Double rel_hoogte;
}
