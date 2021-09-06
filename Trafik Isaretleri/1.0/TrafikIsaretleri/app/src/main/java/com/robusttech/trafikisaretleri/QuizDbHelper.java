package com.robusttech.trafikisaretleri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.robusttech.trafikisaretleri.QuizContract.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TrafikIsaretleri.db";
    private static final int DATABASE_VERSION = 1;

    private int sinavSoruAdedi = 20;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_RESIM + " INTEGER, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_ISARET_TIPI + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {

        /*
        isaretTipi=1    ->  Tehlike Uyari İşaretleri
        isaretTipi=2    ->  Trafik Tanzim İşaretleri
        isaretTipi=3    ->  Bilgi İşaretleri
        isaretTipi=4    ->  Durma ve Parketme İşaretleri
        isaretTipi=5    ->  Yatay İşaretleme
        isaretTipi=6    ->  Yeni İşaretler
         */

        Question question;

        // Tehlike Uyarı İşaretleri , işaret tipi=1
        question = new Question("", R.drawable.tu01,"Sağa tehlikeli viraj", "Sola tehlikeli viraj", "Sağa tehlikeli devamlı virajlar","Sola tehlikeli devamli virajlar", 1,1); addQuestion(question);
        question = new Question("", R.drawable.tu02,"Sağa tehlikeli viraj", "Sola tehlikeli viraj", "Sağa tehlikeli devamlı virajlar","Sola tehlikeli devamli virajlar", 2,1); addQuestion(question);
        question = new Question("", R.drawable.tu03,"Sağa tehlikeli viraj", "Sola tehlikeli viraj", "Sağa tehlikeli devamlı virajlar","Sola tehlikeli devamli virajlar", 3,1); addQuestion(question);
        question = new Question("", R.drawable.tu04,"Sağa tehlikeli viraj", "Sola tehlikeli viraj", "Sağa tehlikeli devamlı virajlar","Sola tehlikeli devamli virajlar", 4,1); addQuestion(question);
        question = new Question("", R.drawable.tu05,"Tehlikeli eğim (çıkış)", "Her iki taraftan daralan kaplama", "Tehlikeli eğim(iniş)","Soldan %10 daralan kaplama", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu06,"Soldan %10 daralan kaplama", "Tehlikeli eğim (çıkış)", "Her iki taraftan daralan kaplama","Tehlikeli eğim (iniş)", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu07,"Sağdan daralan kaplama", "Her iki taraftan genişleyen kaplama", "Soldan daralan kaplama","Her iki taraftan daralan kaplama", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu09,"Sağdan daralan kaplama", "Her iki taraftan genişleyen kaplama", "Soldan daralan kaplama","Her iki taraftan daralan kaplama", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu10,"Sağdan daralan kaplama", "Her iki taraftan genişleyen kaplama", "Soldan daralan kaplama","Her iki taraftan daralan kaplama", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu11,"Bağlantı yolu", "Kasisli yol", "Açılan köprü","Deniz veya nehir kıyısında biten yol", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu12,"Bağlantı yolu", "Kasisli yol", "Açılan köprü","Deniz veya nehir kıyısında biten yol", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu13,"Bağlantı yolu", "Kasisli yol", "Açılan köprü","Deniz veya nehir kıyısında biten yol", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu14,"Kaygan yol", "Virajlı yol", "Gevşek malzemeli zemin","Gevşek şev", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu15,"Kaygan yol", "Virajlı yol", "Gevşek malzemeli zemin","Gevşek şev", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu16,"Kaygan yol", "Virajlı yol", "Gevşek malzemeli zemin","Gevşek şev", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu17,"Kaygan yol", "Yaya geçidi", "Gevşek malzemeli zemin","Gevşek şev", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu18,"Okul geçidi", "Yaya geçidi", "Bisiklet geçebilir","Durak bölgesi", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu19,"Okul geçidi", "Yaya geçidi", "Bisiklet geçebilir","Durak bölgesi", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu20,"Vahşi hayvanlar geçebilir", "Ehli hayvanlar geçebilir", "Bisiklet geçebilir","Durak bölgesi", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu21,"Vahşi hayvanlar geçebilir", "Ehli hayvanlar geçebilir", "Bisiklet geçebilir","Durak bölgesi", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu22,"Yolda çalışma", "Işıklı işaret cihazı", "Havalimanı (Alçak uçuş)","Yandan rüzgar", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu23,"Yolda çalışma", "Işıklı işaret cihazı", "Havalimanı (Alçak uçuş)","Yandan rüzgar", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu24,"Yolda çalışma", "Işıklı işaret cihazı", "Havalimanı (Alçak uçuş)","Yandan rüzgar", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu25,"Yolda çalışma", "Işıklı işaret cihazı", "Havalimanı (Alçak uçuş)","Yandan rüzgar", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu26,"İki yönlü trafik", "Dikkat", "Kontrolsüz kavşak","Ana yol - Tali yol kavşağı", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu27,"İki yönlü trafik", "Dikkat", "Kontrolsüz kavşak","Ana yol - Tali yol kavşağı", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu28,"İki yönlü trafik", "Dikkat", "Kontrolsüz kavşak","Ana yol - Tali yol kavşağı", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu29,"İki yönlü trafik", "Dikkat", "Kontrolsüz kavşak","Ana yol - Tali yol kavşağı", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu30,"Ana yol - Tali yol kavşağı", "Yol ayrimi", "Kontrolsüz kavşak","İki yönlü trafik", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu31,"Yol ayrimi", "Ana yol - Tali yol kavşağı", "Kontrolsüz kavşak","Yandan rüzgar", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu32,"İki yönlü trafik", "Dikkat", "Ana yol - Tali yol kavşağı","Yol ayrimi", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu33,"Bisiklet geçebilir", "Dikkat", "Kontrolsüz kavşak","Ana yol - Tali yol kavşağı", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu34,"Sağdan ana yola giriş", "Soldan ana yola giriş", "Dönel kavşak","Kontrollü demiryolu geçidi", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu35,"Sağdan ana yola giriş", "Soldan ana yola giriş", "Dönel kavşak","Kontrollü demiryolu geçidi", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu36,"Sağdan ana yola giriş", "Soldan ana yola giriş", "Dönel kavşak","Kontrollü demiryolu geçidi", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu37,"Sağdan ana yola giriş", "Soldan ana yola giriş", "Dönel kavşak","Kontrollü demiryolu geçidi", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu38,"Kontrolsüz demiryolu geçidi", "Kontrolsüz demiryolu geçidi(tek hat)", "Kontrolsüz demiryolu geçidi(en az 2 hat)","Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu39,"Kontrolsüz demiryolu geçidi", "Kontrolsüz demiryolu geçidi(tek hat)", "Kontrolsüz demiryolu geçidi(en az 2 hat)","Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu40,"Kontrolsüz demiryolu geçidi", "Kontrolsüz demiryolu geçidi(tek hat)", "Kontrolsüz demiryolu geçidi(en az 2 hat)","Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu41,"Kontrolsüz demiryolu geçidi", "Kontrolsüz demiryolu geçidi(tek hat)", "Kontrolsüz demiryolu geçidi(en az 2 hat)","Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu42,"Kontrolsüz demiryolu geçidi", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu43,"Kontrolsüz demiryolu geçidi", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu44,"Kontrolsüz demiryolu geçidi", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu45,"Kontrolsüz demiryolu geçidi", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu46,"Tehlikeli viraj yön levhası", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu47,"Tehlikeli viraj yön levhası", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Engel işareti", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu48,"Tehlikeli viraj yön levhası", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Onarım yaklaşım levhası(sağ,sol)", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu49,"Tehlikeli viraj yön levhası", "Demiryolu hemzemin geçit yaklaşımı(sağ,sol)", "Köprübaşı levhası(sağ,sol)","Onarım yaklaşım levhası(sağ,sol)", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu50,"Refüj başı ek levhası", "Dönüş adası ek levhası", "Düşük banket","Gizli buzlanma", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu51,"Refüj başı ek levhası", "Dönüş adası ek levhası", "Düşük banket","Gizli buzlanma", 2,1);addQuestion(question);
        question = new Question("", R.drawable.tu52,"Refüj başı ek levhası", "Dönüş adası ek levhası", "Düşük banket","Gizli buzlanma", 3,1);addQuestion(question);
        question = new Question("", R.drawable.tu53,"Refüj başı ek levhası", "Dönüş adası ek levhası", "Düşük banket","Gizli buzlanma", 4,1);addQuestion(question);
        question = new Question("", R.drawable.tu54,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Düşük banket","Gizli buzlanma", 1,1);addQuestion(question);
        question = new Question("", R.drawable.tu55,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Düşük banket","Gizli buzlanma", 2,1);addQuestion(question);




        //Trafik tanzim işaretleri, işaret tipi=2
        question = new Question("", R.drawable.tt01,"Yol ver", "Dur", "Karşıdan gelene yol ver","Girişi olmayan yol", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt02,"Yol ver", "Dur", "Karşıdan gelene yol ver","Girişi olmayan yol", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt03,"Yol ver", "Dur", "Karşıdan gelene yol ver","Girişi olmayan yol", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt04,"Yol ver", "Dur", "Karşıdan gelene yol ver","Girişi olmayan yol", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt05,"Taşıt trafiğine kapalı yol", "Motorsiklet hariç motorlu taşıt trafiğine kapalı yol", "Motorsiklet giremez","Bisiklet giremez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt06,"Taşıt trafiğine kapalı yol", "Motorsiklet hariç motorlu taşıt trafiğine kapalı yol", "Motorsiklet giremez","Bisiklet giremez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt07,"Taşıt trafiğine kapalı yol", "Motorsiklet hariç motorlu taşıt trafiğine kapalı yol", "Motorsiklet giremez","Bisiklet giremez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt08,"Taşıt trafiğine kapalı yol", "Motorsiklet hariç motorlu taşıt trafiğine kapalı yol", "Motorsiklet giremez","Bisiklet giremez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt09,"Motorlu bisiklet giremez", "Kamyon giremez", "Otobüs giremez","Treyler giremez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt10,"Motorlu bisiklet giremez", "Kamyon giremez", "Otobüs giremez","Treyler giremez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt11,"Motorlu bisiklet giremez", "Kamyon giremez", "Otobüs giremez","Treyler giremez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt12,"Motorlu bisiklet giremez", "Kamyon giremez", "Otobüs giremez","Treyler giremez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt13,"Yaya giremez", "At arabası giremez", "El arabası giremez","Traktör giremez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt14,"Yaya giremez", "At arabası giremez", "El arabası giremez","Traktör giremez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt15,"Yaya giremez", "At arabası giremez", "El arabası giremez","Traktör giremez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt16,"Yaya giremez", "At arabası giremez", "El arabası giremez","Traktör giremez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt17,"Belirli miktarlardan fazla patlayıcı ver parlayıcı madde taşıyan taşıt giremez", "Tehlikeli madde taşıyan taşıt giremez", "Belirli miktarlardan fazla su kirletici madde taşıyan taşıt giremez","Motorlu taşıt giremez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt18,"Belirli miktarlardan fazla patlayıcı ver parlayıcı madde taşıyan taşıt giremez", "Tehlikeli madde taşıyan taşıt giremez", "Belirli miktarlardan fazla su kirletici madde taşıyan taşıt giremez","Motorlu taşıt giremez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt19,"Belirli miktarlardan fazla patlayıcı ver parlayıcı madde taşıyan taşıt giremez", "Tehlikeli madde taşıyan taşıt giremez", "Belirli miktarlardan fazla su kirletici madde taşıyan taşıt giremez","Motorlu taşıt giremez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt20,"Belirli miktarlardan fazla patlayıcı ver parlayıcı madde taşıyan taşıt giremez", "Tehlikeli madde taşıyan taşıt giremez", "Belirli miktarlardan fazla su kirletici madde taşıyan taşıt giremez","Motorlu taşıt giremez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt21,"Taşıt giremez", "Genişliği ... metreden fazla olan taşıt giremez", "Yüksekliği ... metreden fazla olan taşıt giremez","Uzunluğu ... metreden fazla olan taşıt giremez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt22,"Taşıt giremez", "Genişliği ... metreden fazla olan taşıt giremez", "Yüksekliği ... metreden fazla olan taşıt giremez","Uzunluğu ... metreden fazla olan taşıt giremez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt23,"Taşıt giremez", "Genişliği ... metreden fazla olan taşıt giremez", "Yüksekliği ... metreden fazla olan taşıt giremez","Uzunluğu ... metreden fazla olan taşıt giremez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt24,"Taşıt giremez", "Genişliği ... metreden fazla olan taşıt giremez", "Yüksekliği ... metreden fazla olan taşıt giremez","Uzunluğu ... metreden fazla olan taşıt giremez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt25,"Dingil başına ... tondan fazla yük düşen taşıt giremez", "Yükü ağırlığı ... tondan fazla olan taşıt giremez", "Öndeki taşıt ... metreden daha fazla yakın takip edilemez","Sağa dönülmez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt26,"Dingil başına ... tondan fazla yük düşen taşıt giremez", "Yükü ağırlığı ... tondan fazla olan taşıt giremez", "Öndeki taşıt ... metreden daha fazla yakın takip edilemez","Sağa dönülmez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt27,"Dingil başına ... tondan fazla yük düşen taşıt giremez", "Yükü ağırlığı ... tondan fazla olan taşıt giremez", "Öndeki taşıt ... metreden daha fazla yakın takip edilemez","Sağa dönülmez", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt28,"Dingil başına ... tondan fazla yük düşen taşıt giremez", "Yükü ağırlığı ... tondan fazla olan taşıt giremez", "Öndeki taşıt ... metreden daha fazla yakın takip edilemez","Sağa dönülmez", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt29,"Sola dönülmez", "U dönüşü yapılmaz", "Öndeki taşıtı geçmek yasaktır","Sağa dönülmez", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt30,"Sola dönülmez", "U dönüşü yapılmaz", "Öndeki taşıtı geçmek yasaktır","Sağa dönülmez", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt31,"Sola dönülmez", "U dönüşü yapılmaz", "Öndeki taşıtı geçmek yasaktır","Kamyonlar için öndeki taşıtı geçmek yasaktır", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt32,"Sola dönülmez", "U dönüşü yapılmaz", "Öndeki taşıtı geçmek yasaktır","Kamyonlar için öndeki taşıtı geçmek yasaktır", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt33,"Azami hız sınırlaması", "Okul bölgesi azami hız sınırı", "Sesli ikaz cihazlarının kullanımı yasaktır","Gümrük (durmadan geçmek yasaktır)", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt34,"Azami hız sınırlaması", "Okul bölgesi azami hız sınırı", "Sesli ikaz cihazlarının kullanımı yasaktır","Gümrük (durmadan geçmek yasaktır)", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt35,"Azami hız sınırlaması", "Okul bölgesi azami hız sınırı", "Sesli ikaz cihazlarının kullanımı yasaktır","Gümrük (durmadan geçmek yasaktır)", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt36,"Azami hız sınırlaması", "Okul bölgesi azami hız sınırı", "Sesli ikaz cihazlarının kullanımı yasaktır","Gümrük (durmadan geçmek yasaktır)", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt37,"Bütün yasaklama kısıtlarının sonu", "Hız sınırlaması sonu", "Geçme yasağı sonu","Kamyonlar için geçme yasağı sonu", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt38,"Bütün yasaklama kısıtlarının sonu", "Hız sınırlaması sonu", "Geçme yasağı sonu","Kamyonlar için geçme yasağı sonu", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt39,"Bütün yasaklama kısıtlarının sonu", "Hız sınırlaması sonu", "Geçme yasağı sonu","Kamyonlar için geçme yasağı sonu", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt40,"Bütün yasaklama kısıtlarının sonu", "Hız sınırlaması sonu", "Geçme yasağı sonu","Kamyonlar için geçme yasağı sonu", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt41,"Sağa mecburi yön", "Sola mecburi yön", "İleri mecburi yön","İleri ve sağa mecburi yön", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt42,"Sağa mecburi yön", "Sola mecburi yön", "İleri mecburi yön","İleri ve sağa mecburi yön", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt43,"Sağa mecburi yön", "Sola mecburi yön", "İleri mecburi yön","İleri ve sağa mecburi yön", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt44,"Sağa mecburi yön", "Sola mecburi yön", "İleri mecburi yön","İleri ve sağa mecburi yön", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt45,"İleri ve sola mecburi yön", "Sağa ve sola mecburi yön", "İleriden sağa mecburi yön","İleriden sola mecburi yön", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt46,"İleri ve sola mecburi yön", "Sağa ve sola mecburi yön", "İleriden sağa mecburi yön","İleriden sola mecburi yön", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt47,"İleri ve sola mecburi yön", "Sağa ve sola mecburi yön", "İleriden sağa mecburi yön","İleriden sola mecburi yön", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt48,"İleri ve sola mecburi yön", "Sağa ve sola mecburi yön", "İleriden sağa mecburi yön","İleriden sola mecburi yön", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt49,"Sağdan gidiniz", "Soldan gidiniz", "Her iki yandan gidiniz","Ada etrafında dönünüz", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt50,"Sağdan gidiniz", "Soldan gidiniz", "Her iki yandan gidiniz","Ada etrafında dönünüz", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt51,"Sağdan gidiniz", "Soldan gidiniz", "Her iki yandan gidiniz","Ada etrafında dönünüz", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt52,"Sağdan gidiniz", "Soldan gidiniz", "Her iki yandan gidiniz","Ada etrafında dönünüz", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt53,"Mecburi bisiklet yolu", "Mecburi bisiklet yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt54,"Mecburi bisiklet yolu", "Mecburi bisiklet yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt55,"Mecburi bisiklet yolu", "Mecburi bisiklet yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt56,"Mecburi bisiklet yolu", "Mecburi bisiklet yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt57,"Mecburi at yolu", "Mecburi at yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt58,"Mecburi at yolu", "Mecburi at yolu sonu", "Mecburi yaya yolu","Mecburi yaya yolu sonu", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt59,"Mecburi azami hız", "Mecburi azami hız sonu", "Mecburi asgari hız","Mecburi asgari hız sonu", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt60,"Mecburi azami hız", "Mecburi azami hız sonu", "Mecburi asgari hız","Mecburi asgari hız sonu", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt61,"Zincir takmak mecburidir", "Zincir takma mecburiyeti sonu", "Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön","Mecburi asgari hız sonu", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt62,"Zincir takmak mecburidir", "Zincir takma mecburiyeti sonu", "Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön","Mecburi asgari hız sonu", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt63,"Zincir takmak mecburidir", "Zincir takma mecburiyeti sonu", "Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön","Mecburi asgari hız sonu", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt64,"Zincir takmak mecburidir", "Zincir takma mecburiyeti sonu", "Mecburi asgari hız","Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt65,"Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön", "Yayalar ve bisikletliler tarafından kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu","Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", 1,2);addQuestion(question);
        question = new Question("", R.drawable.tt66,"Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön", "Yayalar ve bisikletliler tarafından kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu","Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", 2,2);addQuestion(question);
        question = new Question("", R.drawable.tt67,"Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön", "Yayalar ve bisikletliler tarafından kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu","Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", 3,2);addQuestion(question);
        question = new Question("", R.drawable.tt68,"Tehlikeli madde taşıyan taşıtların izleyecekleri mecburi yön", "Yayalar ve bisikletliler tarafından kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu","Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", 4,2);addQuestion(question);
        question = new Question("", R.drawable.tt69,"Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yol", "Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu","Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yolun sonu", 4,2);addQuestion(question);



        // Bilgi işaretleri, işaret tipi=3
        question = new Question("", R.drawable.bi01,"Kavşak öncesi yol levhası", "Kaplama üstü yön levhası", "Refüj ortası yol levhası","Girişi olmayan yol kavşağı", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi02,"Kavşak öncesi yol levhası", "Kaplama üstü yön levhası", "Refüj ortası yol levhası","Girişi olmayan yol kavşağı", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi03,"Kavşak öncesi yol levhası", "Kaplama üstü yön levhası", "Refüj ortası yol levhası","Girişi olmayan yol kavşağı", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi04,"Kavşak öncesi yol levhası", "Kaplama üstü yön levhası", "Refüj ortası yol levhası","Girişi olmayan yol kavşağı", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi05,"Girişi olmayan yol kavşağı", "Kaplama üstü yön levhası", "Refüj ortası yol levhası","İleriki kavşakta sola dönüş yasağını gösteren işaret levhası", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi06,"Kaplama üstü yön levhası", "Girişi olmayan yol kavşağı", "Refüj ortası yol levhası","Kavşak öncesi şerit seçim levhası", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi07,"Kaplama üstü yön levhası", "Refüj ortası yol levhası", "Girişi olmayan yol kavşağı","İleriki kavşakta sola dönüş yasağını gösteren işaret levhası", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi08,"Kavşak öncesi şerit seçim levhası", "Refüj ortası yol levhası", "Girişi olmayan yol kavşağı","İleriki kavşakta sola dönüş yasağını gösteren işaret levhası", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi09,"Kavşak öncesi şerit seçim levhası", "Kavşak içi yön levhası", "İl sınırı levhası","Girişi olmayan yol kavşağı", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi10,"Kavşak öncesi şerit seçim levhası", "Kavşak içi yön levhası (turistik mahal)", "Kavşak içi yön levhası (metro)","Kavşak içi yön levhası (havalimanı)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi11,"Kavşak içi yön levhası (kamp yeri)", "Kavşak içi yön levhası (turistik mahal)", "Kavşak içi yön levhası (metro)","Kavşak içi yön levhası (havalimanı)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi12,"Kavşak içi yön levhası (kamp yeri)", "Kavşak içi yön levhası (turistik mahal)", "Kavşak içi yön levhası (metro)","Kavşak içi yön levhası (havalimanı)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi13,"Kavşak içi yön levhası (kamp yeri)", "Kavşak içi yön levhası (turistik mahal)", "Kavşak içi yön levhası (metro)","Kavşak içi yön levhası (havalimanı)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi14,"Türkiye devlet sınırı levhası", "İl sınırı levhası", "Türkiye hız sınırları levhası","Meskun mahal levhası (il merkezi)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi15,"Türkiye devlet sınırı levhası", "İl sınırı levhası", "Türkiye hız sınırları levhası","Meskun mahal levhası (il merkezi)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi16,"Türkiye devlet sınırı levhası", "İl sınırı levhası", "Türkiye hız sınırları levhası","Meskun mahal levhası (il merkezi)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi17,"Meskun mahal levhası (il merkezi)", "Meskun mahal levhası (ilçe merkezi)", "Meskun mahal levhası (köy-belde-bucak merkezi)","Meskun mahal sonu levhası (il merkezi)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi18,"Meskun mahal levhası (il merkezi)", "Meskun mahal levhası (ilçe merkezi)", "Meskun mahal levhası (köy-belde-bucak merkezi)","Meskun mahal sonu levhası (il merkezi)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi19,"Meskun mahal levhası (il merkezi)", "Meskun mahal levhası (ilçe merkezi)", "Meskun mahal levhası (köy-belde-bucak merkezi)","Meskun mahal sonu levhası (il merkezi)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi20,"Meskun mahal levhası (il merkezi)", "Meskun mahal levhası (ilçe merkezi)", "Meskun mahal levhası (köy-belde-bucak merkezi)","Meskun mahal sonu levhası (il merkezi)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi21,"Meskun mahal sonu levhası (ilçe merkezi)", "Meskun mahal sonu levhası (köy-belde-bucak merkezi)", "Coğrafi bilgi levhası (dağ geçidi)","Coğrafi bilgi levhası (köprü-nehir)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi22,"Meskun mahal sonu levhası (ilçe merkezi)", "Meskun mahal sonu levhası (köy-belde-bucak merkezi)", "Coğrafi bilgi levhası (dağ geçidi)","Coğrafi bilgi levhası (köprü-nehir)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi23,"Meskun mahal sonu levhası (ilçe merkezi)", "Meskun mahal sonu levhası (köy-belde-bucak merkezi)", "Coğrafi bilgi levhası (dağ geçidi)","Coğrafi bilgi levhası (köprü-nehir)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi24,"Meskun mahal sonu levhası (ilçe merkezi)", "Meskun mahal sonu levhası (köy-belde-bucak merkezi)", "Coğrafi bilgi levhası (dağ geçidi)","Coğrafi bilgi levhası (köprü-nehir)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi25,"Coğrafi bilgi levhası (dağ)", "Coğrafi bilgi levhası (göl)", "Karayolları teşkilatına ait bilgi levhası (bölge merkezi)","Meskun mahal ve kavşak çıkışı mesafe levhası", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi26,"Coğrafi bilgi levhası (dağ)", "Coğrafi bilgi levhası (göl)", "Karayolları teşkilatına ait bilgi levhası (bölge merkezi)","Meskun mahal ve kavşak çıkışı mesafe levhası", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi27,"Coğrafi bilgi levhası (dağ)", "Coğrafi bilgi levhası (göl)", "Karayolları teşkilatına ait bilgi levhası (bölge merkezi)","Meskun mahal ve kavşak çıkışı mesafe levhası", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi28,"Coğrafi bilgi levhası (dağ)", "Coğrafi bilgi levhası (göl)", "Karayolları teşkilatına ait bilgi levhası (bölge merkezi)","Meskun mahal ve kavşak çıkışı mesafe levhası", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi29,"Mesafe levhası", "Yaya geçidi", "Okul geçidi","Yaya bölgesi", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi30,"Mesafe levhası", "Yaya geçidi", "Okul geçidi","Yaya bölgesi", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi31,"Mesafe levhası", "Yaya geçidi", "Okul geçidi","Yaya bölgesi", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi32,"Mesafe levhası", "Yaya geçidi", "Okul geçidi","Yaya bölgesi", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi33,"Yaya bölgesi", "Yaya geçidi", "Okul geçidi","Mesafe levhası", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi34,"Yaya geçidi", "Yaya bölgesi", "Okul geçidi","Mesafe levhası", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi35,"Okul geçidi", "Yaya geçidi", "Yaya bölgesi","Mesafe levhası", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi36,"Yaya bölgesi", "Yaya geçidi", "Okul geçidi","Hastane", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi37,"Tek yönlü yol", "Hastane", "İleri çıkmaz yol","Otoyol başlangıcı", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi38,"Hastane", "İleri tek yönlü yol", "İleri çıkmaz yol","Otoyol başlangıcı", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi39,"Tek yönlü yol", "Hastane", "İleri çıkmaz yol","Otoyol başlangıcı", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi40,"Tek yönlü yol", "Hastane", "İleri çıkmaz yol","Otoyol başlangıcı", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi41,"Otoyol sonu", "Motorlu taşıt yolu başlangıcı", "Motorlu taşıt yolu sonu","Durak", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi42,"Otoyol sonu", "Motorlu taşıt yolu başlangıcı", "Motorlu taşıt yolu sonu","Durak", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi43,"Otoyol sonu", "Motorlu taşıt yolu başlangıcı", "Motorlu taşıt yolu sonu","Durak", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi44,"Otoyol sonu", "Motorlu taşıt yolu başlangıcı", "Motorlu taşıt yolu sonu","Durak", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi45,"İlk yardım", "Tamirhane", "Telefon","Akaryakıt istasyonu", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi46,"İlk yardım", "Tamirhane", "Telefon","Akaryakıt istasyonu", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi47,"İlk yardım", "Tamirhane", "Telefon","Akaryakıt istasyonu", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi48,"İlk yardım", "Tamirhane", "Telefon","Akaryakıt istasyonu", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi49,"Otel veya motel", "Lokanta", "Çayhane veya kafeterya","Çeşme", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi50,"Otel veya motel", "Lokanta", "Çayhane veya kafeterya","Çeşme", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi51,"Otel veya motel", "Lokanta", "Çayhane veya kafeterya","Çeşme", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi52,"Otel veya motel", "Lokanta", "Çayhane veya kafeterya","Çeşme", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi53,"Piknik yeri", "Yürüyüş başlangıcı", "Kamp yeri","Karavanlı kamp yeri", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi54,"Piknik yeri", "Yürüyüş başlangıcı", "Kamp yeri","Karavanlı kamp yeri", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi55,"Piknik yeri", "Yürüyüş başlangıcı", "Kamp yeri","Karavanlı kamp yeri", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi56,"Piknik yeri", "Yürüyüş başlangıcı", "Kamp yeri","Karavanlı kamp yeri", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi57,"Çadırlı ve karavanlı kamp yeri", "Yürüyüş başlangıcı", "Kamp yeri","Karavanlı kamp yeri", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi58,"Çadırlı ve karavanlı kamp yeri", "Gençlik kampı", "Yürüyüş başlangıcı","Karavanlı kamp yeri", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi59,"Anayol", "Anayol sonu", "Önceliği olan yol","Karavanlı kamp yeri", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi60,"Karavanlı kamp yeri", "Anayol sonu", "Önceliği olan yol","Anayol", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi61,"Karavanlı kamp yeri", "Anayol sonu", "Önceliği olan yol","Anayol", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi62,"Jandarma", "Polis", "Yangın tehlikesi","Radyo", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi63,"Jandarma", "Polis", "Yangın tehlikesi","Radyo", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi64,"Jandarma", "Polis", "Yangın tehlikesi","Radyo", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi65,"Jandarma", "Polis", "Yangın tehlikesi","Radyo", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi66,"Turizm danışma", "Alt geçit", "Üst geçit","Rampalı yaya üst geçidi", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi67,"Turizm danışma", "Alt geçit", "Üst geçit","Rampalı yaya üst geçidi", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi68,"Turizm danışma", "Alt geçit", "Üst geçit","Rampalı yaya üst geçidi", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi69,"Turizm danışma", "Alt geçit", "Üst geçit","Rampalı yaya üst geçidi", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi70,"Yüzme yeri", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Tünel", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi71,"Yüzme yeri", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Tünel", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi72,"Yüzme yeri", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Tünel", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi73,"Yüzme yeri", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Tünel", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi74,"Şerit düzenleme levhaları", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Tünel", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi75,"Polis", "Şerit düzenleme levhaları", "Bölünmüş yol öncesi yön levhası","Tünel", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi76,"Bölünmüş yol öncesi yön levhası", "Yüzülmez", "Şerit düzenleme levhaları","Tünel", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi77,"Tünel", "Yüzülmez", "Bölünmüş yol öncesi yön levhası","Şerit düzenleme levhaları", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi78,"Şerit düzenleme levhaları", "Polis", "Yangın tehlikesi","Radyo", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi79,"Jandarma", "Şerit düzenleme levhaları", "Yangın tehlikesi","Radyo", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi80,"Radyo", "Polis", "Şerit düzenleme levhaları","Yangın tehlikesi", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi81,"Radyo", "Yangın tehlikesi", "Polis","Şerit düzenleme levhaları", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi82,"Şerit düzenleme levhaları", "Motorlu taşıt yolu başlangıcı", "Otoyol sonu","Durak", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi83,"Motorlu taşıt yolu başlangıcı", "Şerit düzenleme levhaları", "Otoyol sonu","Durak", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi84,"Otoyol sonu", "Motorlu taşıt yolu başlangıcı", "Şerit düzenleme levhaları","Durak", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi85,"Tünel", "Motorlu taşıt yolu başlangıcı", "Otoyol sonu","Şerit düzenleme levhaları", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi86,"Şerit düzenleme levhaları", "Yaya geçidi", "Okul geçidi","Yaya bölgesi", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi87,"Yaya geçidi", "Şerit düzenleme levhaları", "Okul geçidi","Yaya bölgesi", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi88,"Yaya geçidi", "Okul geçidi", "İki yönlü yol","Yaya bölgesi", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi89,"Yaya geçidi", "Okul geçidi", "Yaya bölgesi","İki yönlü yol", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi90,"U dönüşü levhası", "U dönüşü levhası (sola sığınmalı)", "U dönüşü levhası (sağa sığınmalı)","U dönüşü levhası (alt geçit)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi91,"U dönüşü levhası", "U dönüşü levhası (sola sığınmalı)", "U dönüşü levhası (sağa sığınmalı)","U dönüşü levhası (alt geçit)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi92,"U dönüşü levhası", "U dönüşü levhası (sola sığınmalı)", "U dönüşü levhası (sağa sığınmalı)","U dönüşü levhası (alt geçit)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi93,"U dönüşü levhası", "U dönüşü levhası (sola sığınmalı)", "U dönüşü levhası (sağa sığınmalı)","U dönüşü levhası (alt geçit)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi94,"U dönüşü levhası (alt geçit)", "Kaçış rampası", "U dönüşü levhası (üst geçit)","Karayolları bilgi levhası", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi95,"Kaçış rampası", "U dönüşü levhası (alt geçit)", "U dönüşü levhası (üst geçit)","Karayolları bilgi levhası", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi96,"U dönüşü levhası (alt geçit)", "Kaçış rampası", "U dönüşü levhası (üst geçit)","Karayolları bilgi levhası", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi97,"U dönüşü levhası (alt geçit)", "Kaçış rampası", "U dönüşü levhası (üst geçit)","Karayolları bilgi levhası", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi98,"Kaçış rampası (sağ)", "Kaçış rampası (sol)", "U dönüşü levhası (sola sığınmalı)","U dönüşü levhası (sağa sığınmalı)", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi99,"Kaçış rampası (sol)", "Kaçış rampası (sağ)", "U dönüşü levhası (sola sığınmalı)","U dönüşü levhası (sağa sığınmalı)", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi100,"Şerit düzenleme levhaları", "U dönüşü levhası (üst geçit)", "Kaçış rampası","U dönüşü levhası (sağa sığınmalı)", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi101,"Şerit düzenleme levhaları", "U dönüşü levhası (üst geçit)", "U dönüşü levhası (alt geçit)","Kaçış rampası (sağ)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi102,"Şerit düzenleme levhaları", "U dönüşü levhası (üst geçit)", "U dönüşü levhası (alt geçit)","Kaçış rampası (sol)", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi103,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi104,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi106,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi107,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi108,"Sanayi bölgesi (OSB)", "Trafik elektronik denetleme", "Trafik cebi","Tramvay durağı", 1,3);addQuestion(question);
        question = new Question("", R.drawable.bi109,"Sanayi bölgesi (OSB)", "Trafik elektronik denetleme", "Trafik cebi","Tramvay durağı", 2,3);addQuestion(question);
        question = new Question("", R.drawable.bi110,"Sanayi bölgesi (OSB)", "Trafik cebi", "Trafik elektronik denetleme","Tramvay durağı", 3,3);addQuestion(question);
        question = new Question("", R.drawable.bi111,"Sanayi bölgesi (OSB)", "Tramvay durağı", "Trafik cebi","Trafik elektronik denetleme", 4,3);addQuestion(question);
        question = new Question("", R.drawable.bi112,"Sanayi bölgesi (OSB)", "Tramvay durağı", "Trafik cebi","Trafik elektronik denetleme", 3,3);addQuestion(question);


        // Durma ve Parketme İşaretleri, işaret tipi=4
        question = new Question("", R.drawable.pa01,"Park etmek yasaktır", "Duraklamak ve park etmek yasaktır", "Park yeri","Kapalı park yeri", 1,4);addQuestion(question);
        question = new Question("", R.drawable.pa02,"Park etmek yasaktır", "Duraklamak ve park etmek yasaktır", "Park yeri","Kapalı park yeri", 2,4);addQuestion(question);
        question = new Question("", R.drawable.pa03,"Park etmek yasaktır", "Duraklamak ve park etmek yasaktır", "Park yeri","Kapalı park yeri", 3,4);addQuestion(question);
        question = new Question("", R.drawable.pa04,"Park etmek yasaktır", "Duraklamak ve park etmek yasaktır", "Kapalı park yeri","Park yeri", 4,4);addQuestion(question);
        question = new Question("", R.drawable.pa05,"Park yeri", "Park yeri (metrodan yararlanacaklar için)", "Park yeri (tramvaydan yararlanacaklar için)","Kapalı park yeri", 1,4);addQuestion(question);
        question = new Question("", R.drawable.pa06,"Park yeri (metrodan yararlanacaklar için)", "Park yeri", "Park yeri (tramvaydan yararlanacaklar için)","Kapalı park yeri", 2,4);addQuestion(question);
        question = new Question("", R.drawable.pa07,"Park yeri (tramvaydan yararlanacaklar için)", "Park yeri (metrodan yararlanacaklar için)", "Park yeri","Kapalı park yeri", 3,4);addQuestion(question);
        question = new Question("", R.drawable.pa08,"Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)", "Park yeri (tramvaydan yararlanacaklar için)","Park yeri", 4,4);addQuestion(question);
        question = new Question("", R.drawable.pa09,"Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)", "Park yeri (tramvaydan yararlanacaklar için)","Park yeri", 2,4);addQuestion(question);
        question = new Question("", R.drawable.pa10,"Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)", "Park yeri (tramvaydan yararlanacaklar için)","Park yeri", 3,4);addQuestion(question);


        // Yatay İşaretleme, işaret tipi=5
        question = new Question("", R.drawable.yi01,"Öndeki araç geçilebilir", "Öndeki aracı geçmek yasaktır", "Kesikli çizgi tarafındaki araç öndeki aracı geçebilir. Devamlı çizgi tarafındaki aracın öndeki aracı geçmesi yasaktır","Orta şerit sadece geçiş içindir. Devamlı olarak işgal edilemez", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi02,"Öndeki araç geçilebilir", "Öndeki aracı geçmek yasaktır", "Kesikli çizgi tarafındaki araç öndeki aracı geçebilir. Devamlı çizgi tarafındaki aracın öndeki aracı geçmesi yasaktır","Orta şerit sadece geçiş içindir. Devamlı olarak işgal edilemez", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi03,"Öndeki araç geçilebilir", "Öndeki aracı geçmek yasaktır", "Kesikli çizgi tarafındaki araç öndeki aracı geçebilir. Devamlı çizgi tarafındaki aracın öndeki aracı geçmesi yasaktır","Orta şerit sadece geçiş içindir. Devamlı olarak işgal edilemez", 3,5);addQuestion(question);
        question = new Question("", R.drawable.yi04,"Öndeki araç geçilebilir", "Öndeki aracı geçmek yasaktır", "Kesikli çizgi tarafındaki araç öndeki aracı geçebilir. Devamlı çizgi tarafındaki aracın öndeki aracı geçmesi yasaktır","Orta şerit sadece geçiş içindir. Devamlı olarak işgal edilemez", 4,5);addQuestion(question);
        question = new Question("", R.drawable.yi05,"Her iki yöndeki araçlar da çizginin diğer tarafına geçemez", "Ayrılma", "Katılma","Bölünmüş yol başlangıcı", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi06,"Her iki yöndeki araçlar da çizginin diğer tarafına geçemez", "Ayrılma", "Katılma","Bölünmüş yol başlangıcı", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi07,"Her iki yöndeki araçlar da çizginin diğer tarafına geçemez", "Ayrılma", "Katılma","Bölünmüş yol başlangıcı", 3,5);addQuestion(question);
        question = new Question("", R.drawable.yi08,"Her iki yöndeki araçlar da çizginin diğer tarafına geçemez", "Ayrılma", "Katılma","Bölünmüş yol başlangıcı", 4,5);addQuestion(question);
        question = new Question("", R.drawable.yi09,"Taralı alana girilmez", "Yaya geçidi", "Katılma","Yavaşlama uyarı çizgileri", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi10,"Taralı alana girilmez", "Yaya geçidi", "Katılma","Yavaşlama uyarı çizgileri", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi11,"Taralı alana girilmez", "Katılma", "Yaya geçidi","Yavaşlama uyarı çizgileri", 3,5);addQuestion(question);
        question = new Question("", R.drawable.yi12,"Taralı alana girilmez", "Yaya geçidi", "Katılma","Yavaşlama uyarı çizgileri", 4,5);addQuestion(question);
        question = new Question("", R.drawable.yi13,"Yol ver", "Dur", "Azami hız","Bisiklet yolu", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi14,"Yol ver", "Dur", "Azami hız","Bisiklet yolu", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi15,"Yol ver", "Dur", "Azami hız","Bisiklet yolu", 3,5);addQuestion(question);
        question = new Question("", R.drawable.yi16,"Yol ver", "Dur", "Azami hız","Bisiklet yolu", 4,5);addQuestion(question);
        question = new Question("", R.drawable.yi17,"Engelli sürücüler için park yeri", "Bu şerit sadece ileri yönde seyir içindir", "Bu şerit sadece ileri seyir veya sola dönüş içindir","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi18,"Engelli sürücüler için park yeri", "Bu şerit sadece ileri yönde seyir içindir", "Bu şerit sadece ileri seyir veya sola dönüş içindir","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi19,"Engelli sürücüler için park yeri", "Bu şerit sadece ileri yönde seyir içindir", "Bu şerit sadece ileri seyir veya sola dönüş içindir","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 3,5);addQuestion(question);
        question = new Question("", R.drawable.yi20,"Engelli sürücüler için park yeri", "Bu şerit sadece ileri yönde seyir içindir", "Bu şerit sadece ileri seyir veya sola dönüş içindir","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 4,5);addQuestion(question);
        question = new Question("", R.drawable.yi21,"Bu şerit sadece sola dönüş içindir", "Bu şerit sadece sağa dönüş içindir", "Sağa geç","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 1,5);addQuestion(question);
        question = new Question("", R.drawable.yi22,"Bu şerit sadece sola dönüş içindir", "Bu şerit sadece sağa dönüş içindir", "Sağa geç","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 2,5);addQuestion(question);
        question = new Question("", R.drawable.yi23,"Bu şerit sadece sola dönüş içindir", "Bu şerit sadece sağa dönüş içindir", "Sağa geç","Bu şerit sadece ileri seyir veya sağa dönüş içindir", 3,5);addQuestion(question);


        // Yeni İşaretler, işaret tipi=6
        question = new Question("", R.drawable.ys01,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Okul bölgesi azami hız sınırı","Yayalar ve bisikletliler tarafından kullanılabilen yol", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys02,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Okul bölgesi azami hız sınırı","Yayalar ve bisikletliler tarafından kullanılabilen yol", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys03,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Okul bölgesi azami hız sınırı","Yayalar ve bisikletliler tarafından kullanılabilen yol", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys04,"Trafik sıkışıklığı", "Tramvay hattı ile oluşan kavşak", "Okul bölgesi azami hız sınırı","Yayalar ve bisikletliler tarafından kullanılabilen yol", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys05,"Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yolun sonu","Girişi olmayan yol kavşağı", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys06,"Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yolun sonu","Girişi olmayan yol kavşağı", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys07,"Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yolun sonu","Girişi olmayan yol kavşağı", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys08,"Yayalar ve bisikletliler tarafından kullanılabilen yolun sonu", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yol", "Yayalar ve bisikletliler için ayrı ayrı kullanılabilen yolun sonu","Girişi olmayan yol kavşağı", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys09,"Kavşak içi yön levhası (Metro)", "İleri tek yönlü yol", "Rampalı yaya üst geçidi","İki yönlü trafik", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys10,"Kavşak içi yön levhası (Metro)", "İleri tek yönlü yol", "Rampalı yaya üst geçidi","İki yönlü trafik", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys11,"Kavşak içi yön levhası (Metro)", "İleri tek yönlü yol", "Rampalı yaya üst geçidi","İki yönlü trafik", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys12,"Kavşak içi yön levhası (Metro)", "İleri tek yönlü yol", "Rampalı yaya üst geçidi","İki yönlü trafik", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys13,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys14,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys15,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys16,"Yaya öncelikli yol", "Yaya öncelikli yolun sonu", "İstasyon","Tramvay durağı", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys17,"Sanayi bölgesi (OSB)", "Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)","Park yeri (tramvaydan yararlanacaklar için)", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys18,"Sanayi bölgesi (OSB)", "Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)","Park yeri (tramvaydan yararlanacaklar için)", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys19,"Sanayi bölgesi (OSB)", "Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)","Park yeri (tramvaydan yararlanacaklar için)", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys20,"Sanayi bölgesi (OSB)", "Kapalı park yeri", "Park yeri (metrodan yararlanacaklar için)","Park yeri (tramvaydan yararlanacaklar için)", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys21,"Ağaç engeli", "Araç çekilir", "İki yönlü trafik","Askeri araç çıkabilir", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys22,"Ağaç engeli", "Araç çekilir", "İki yönlü trafik","Askeri araç çıkabilir", 2,6);addQuestion(question);
        question = new Question("", R.drawable.ys23,"Ağaç engeli", "Araç çekilir", "İki yönlü trafik","Askeri araç çıkabilir", 3,6);addQuestion(question);
        question = new Question("", R.drawable.ys24,"Ağaç engeli", "Araç çekilir", "Askeri araç çıkabilir","İki yönlü trafik", 4,6);addQuestion(question);
        question = new Question("", R.drawable.ys25,"Askeri araç çıkabilir", "Araç çekilir", "Yüksek gerilim hattı","İki yönlü trafik", 1,6);addQuestion(question);
        question = new Question("", R.drawable.ys26,"Askeri araç çıkabilir", "Araç çekilir", "Yüksek gerilim hattı","İki yönlü trafik", 3,6);addQuestion(question);


    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_RESIM, question.getResim());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_ISARET_TIPI, question.getIsaretTipi());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    public List<Question> getAllQuestions(int isaretTipi) {

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c;

        if (isaretTipi==0) {
            c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        } else {
            c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_ISARET_TIPI + " = ?", new String[]{isaretTipi + ""});
        }

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setResim(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_RESIM)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();

        Collections.shuffle(questionList);

        int listUzunluk=questionList.size();
        if (listUzunluk<sinavSoruAdedi) {
            sinavSoruAdedi = listUzunluk;
        }

        return questionList.subList(0,sinavSoruAdedi);
    }


    public List<Question> getIsaretler(int isaretTipi) {

        /*
        isaretTipi=1    ->  Tehlike Uyari İşaretleri
        isaretTipi=2    ->  Trafik Tanzim İşaretleri
        isaretTipi=3    ->  Bilgi İşaretleri
        isaretTipi=4    ->  Durma ve Parketme İşaretleri
        isaretTipi=5    ->  Yatay İşaretleme
        isaretTipi=6    ->  Yeni İşaretler
         */

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE "+ QuestionsTable.COLUMN_ISARET_TIPI + " = ?", new String[]{isaretTipi+""});

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setResim(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_RESIM)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
