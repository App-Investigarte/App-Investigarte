package com.app_investigarte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        LatLng antioquia = new LatLng(6.55, -75.817);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.0f));
        mMap.addMarker(new MarkerOptions().position(antioquia)
                .title("Departamento de Antioquia")
                .snippet("Population: 6680000"));

        //Urabá Antioqueño
        LatLng apartado=new LatLng(7.883,-76.633);
        mMap.addMarker(new MarkerOptions().position(apartado)
                        .title("Municipio de Apartadó"));

        LatLng turbo=new LatLng(8.0926,-76.7282);
        mMap.addMarker(new MarkerOptions().position(turbo)
                .title("Municipio de Turbo"));

        LatLng necocli=new LatLng(8.4357, -76.7767);
        mMap.addMarker(new MarkerOptions().position(necocli)
                .title("Municipio de Necoclí"));


        LatLng chigorodo=new LatLng( 7.667, -76.683);
        mMap.addMarker(new MarkerOptions().position(chigorodo)
                .title("Municipio de Chigorodó"));

        LatLng sanPedroUraba=new LatLng( 8.283, -76.383);
        mMap.addMarker(new MarkerOptions().position( sanPedroUraba)
                .title("Municipio de San Pedro de Urabá"));

        LatLng mutata=new LatLng( 7.233,  -76.433);
        mMap.addMarker(new MarkerOptions().position( mutata)
                .title("Municipio de Mutatá"));


        //Suroeste Antioqueño

        LatLng jerico=new LatLng( 6.267, -75.783);
        mMap.addMarker(new MarkerOptions().position(jerico)
                .title("Municipio de Jericó"));

        LatLng jardin=new LatLng( 5.6, -75.817);
        mMap.addMarker(new MarkerOptions().position(jardin)
                .title("Municipio de Jardín"));

        LatLng amaga=new LatLng( 6.05, -75.683);
        mMap.addMarker(new MarkerOptions().position(amaga)
                .title("Municipio de Amagá"));

        LatLng andes=new LatLng( 5.65, -75.867);
        mMap.addMarker(new MarkerOptions().position(andes)
                .title("Municipio de Andes"));

        LatLng betania=new LatLng( 5.733, -75.967);
        mMap.addMarker(new MarkerOptions().position(betania)
                .title("Municipio de Betania"));

        LatLng caramanta=new LatLng( 5.617, -75.85);
        mMap.addMarker(new MarkerOptions().position(caramanta)
                .title("Municipio de Caramanta"));

        LatLng ciudadBolivar=new LatLng( 5.85, -76.017);
        mMap.addMarker(new MarkerOptions().position(ciudadBolivar)
                .title("Municipio de Ciudad Bolivar"));

        LatLng concordia=new LatLng( 6.05, -75.9);
        mMap.addMarker(new MarkerOptions().position(concordia)
                .title("Municipio de Concordia"));

        LatLng hispania=new LatLng( 5.8, -75.9);
        mMap.addMarker(new MarkerOptions().position(hispania)
                .title("Municipio de Hispania"));

        LatLng salgar=new LatLng( 5.95, -75.967);
        mMap.addMarker(new MarkerOptions().position(salgar)
                .title("Municipio de Salgar"));

        LatLng tarso=new LatLng( 5.867, -75.817);
        mMap.addMarker(new MarkerOptions().position(tarso)
                .title("Municipio de Tarso"));

        LatLng titiribi=new LatLng( 6.05, -75.783);
        mMap.addMarker(new MarkerOptions().position(titiribi)
                .title("Municipio de Titiribí"));

        LatLng urrao=new LatLng( 6.317, -76.133);
        mMap.addMarker(new MarkerOptions().position(urrao)
                .title("Municipio de Urrao"));

        LatLng fredonia=new LatLng( 5.917, -75.667);
        mMap.addMarker(new MarkerOptions().position(fredonia)
                .title("Municipio de Fredonia"));

        LatLng valparaiso=new LatLng(  5.617, -75.633);
        mMap.addMarker(new MarkerOptions().position(valparaiso)
                .title("Municipio de Valparaiso"));













        mMap.setMinZoomPreference(5.5f);

        LatLngBounds colombia = new LatLngBounds(
                new LatLng(2, -78), // SW bounds
                new LatLng(9, -67)  // NE bounds
        );

        // Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(colombia);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.00, -73.817))
                .title("Antioquia"))
               ;



        //Add Poligono
        mMap.addPolygon(new PolygonOptions()
                .add(
                        new LatLng(3, -77.38),
                        new LatLng(7.2, -77.80),
                        new LatLng(10, -75.21),
                        new LatLng(12, -71.25),
                        new LatLng(6.9, -67.38),
                        new LatLng(2, -67.67),
                        new LatLng(-2.20, -71.32))
                .strokeColor(Color.RED)
                .fillColor(Color.TRANSPARENT));
        ///Nota Los dibujos de los mapas hay que ponerlos en otra clase para ser mas organizados y no enredarnos mucho.

        // Add Polyline
        GoogleMap map;
        // ... get a map.
        // Add a thin red line from London to New York.
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(
                        new LatLng(1.4743, -78.8764),
                        new LatLng(1.45720220369382275, -78.85217305272818),
                        new LatLng(1.455781930952765, -78.8577260434628),
                        new LatLng(1.4533707317226374, -78.84800087660551),
                        new LatLng(1.4497130374571854, -78.84493678808212),
                        new LatLng(1.4479269221648505, -78.84366575628519),
                        new LatLng(1.44686029857149, -78.84248994290829),
                        new LatLng(1.4451758527356064, -78.8411283865571),


                        new LatLng(1.4450659171433249, -78.84108614146512),
                        new LatLng(1.4432275117096707, -78.83859537541866),
                        new LatLng(1.4420691646968182, -78.83640233427286),
                        new LatLng(1.441408294819998, -78.83450400084257),
                        new LatLng(1.4411259962942837, -78.8294292613864),
                        new LatLng(1.4406738518149733, -78.82521349936724),
                        new LatLng(1.4392161963927543, -78.82270932197571),
                        new LatLng( 1.4366930325404732, -78.8204673305154),

                        new LatLng(1.4346146379061433, -78.81886135786772),
                        new LatLng(1.4334435500153575, -78.81795812398195),
                        new LatLng(1.4310081947452777, -78.8153610751033),
                        new LatLng(1.429553549708485, -78.8123171031475),
                        new LatLng(1.4276393829114082, -78.80698051303625),
                        new LatLng(1.4276293277498002, -78.80701571702957),
                        new LatLng(1.4286874656819688, -78.80456484854221),
                        new LatLng( 1.4284592136066767, -78.80339741706848),

                        new LatLng(1.4278435026825915, -78.80193829536438),
                        new LatLng(1.4270065779883794, -78.80102064460516),
                        new LatLng(1.4257034283188936, -78.79991959780455),
                        new LatLng(1.425041462862138, -78.79945758730173),
                        new LatLng(1.4242437523374214, -78.79929497802),
                        new LatLng(1.417590567682397, -78.79907436668873),
                        new LatLng(1.4161335679639417, -78.79869617521763),
                        new LatLng( 1.413511837615847, -78.7978046759963),

                        new LatLng(1.41119800914627718, -78.79667446017265),
                        new LatLng(1.4118101580745936, -78.79628587514162),
                        new LatLng(1.4081386553709812, -78.79360031336546),
                        new LatLng(1.4059660508091365, -78.78832742571831),
                        new LatLng(1.4061500619804939, -78.7860395014286),
                        new LatLng(1.4050332580725653, -78.78231927752485),
                        new LatLng(1.404543902050282, -78.78161117434502),
                        new LatLng( 1.39686468603069, -78.78030326217413),
                        new LatLng( 1.3956433025791692, -78.78035690635443),

                        new LatLng(1.3915256536432754, -78.77841096371412),
                        new LatLng(1.3907034637022868, -78.77726934850216),
                        new LatLng(1.3901215957193271, -78.7757431715727),
                        new LatLng(1.3904118593739152, -78.76801338046789),
                        new LatLng(1.39046917471026, -78.76690227538347),
                        new LatLng(1.3906501705001375, -78.7658840417862),
                        new LatLng(1.3913614167843535, -78.76522086560726),
                        new LatLng( 1.39161078866359, -78.76496907323599),
                        new LatLng( 1.3921360113391108, -78.76456841826439),

                        new LatLng(1.3925533068721883, -78.7639766590049),
                        new LatLng(1.392862675320098, -78.7633966282101),
                        new LatLng(1.3929226720133092, -78.75858675688505),
                        new LatLng(1.3913258879929797, -78.75472571700811),
                        new LatLng(1.389103661581765, -78.75222086906433),
                        new LatLng(1.3880404780103726, -78.75144436955452),
                        new LatLng(1.3786437512710799, -78.74696541577578),
                        new LatLng( 1.3783102480695761, -78.74596059322357),
                        new LatLng( 1.3774149844705836, -78.74528400599957),
                        new LatLng( 1.3772111954800388, -78.74498896300784),

                        new LatLng(1.377130752452653, -78.74435126781464),
                        new LatLng(1.3770617055186523, -78.74418497085571),
                        new LatLng(1.3761416381732703, -78.74413333833218),
                        new LatLng(1.3759975110159695, -78.74394122511148),
                        new LatLng(1.3760601895714877, -78.74373637139797),
                        new LatLng(1.3762118384260462, -78.7435697396292),
                        new LatLng(1.3764298924617404, -78.7433809787035),
                        new LatLng( 1.3765535736515844, -78.74327201396227),
                        new LatLng( 1.377124384046207, -78.74282844364643),
                        new LatLng( 1.3772111954800388, -78.74270237982273),

                        new LatLng(1.3772504114549062, -78.7420690432191),
                        new LatLng(1.3770617055186523, -78.74418497085571),
                        new LatLng(1.3771736554009322, -78.74089792370796),
                        new LatLng(1.3769068526788186, -78.74035410583019),
                        new LatLng(1.3760678986985346, -78.73956587165594),
                        new LatLng(1.374979235642586, -78.73879071325064),
                        new LatLng(1.3739133643124688, -78.73776007443668),
                        new LatLng( 1.3733720489737014, -78.73735170811415),
                        new LatLng( 1.37316892999761, -78.73727861791849),
                        new LatLng( 1.372985217964495, -78.73714216053486),

                        new LatLng(1.3723638278797037, -78.7365118414136),
                        new LatLng(1.370979199082273, -78.73488742858171),
                        new LatLng(1.370620221115151, -78.73426046222448),
                        new LatLng(1.3705404482262602, -78.73386953026056),
                        new LatLng(1.3704100631206233, -78.73353727161884),
                        new LatLng(1.3702542043089379, -78.7332958728075),
                        new LatLng(1.3699525420639875, -78.73294819146396),
                        new LatLng( 1.3684133936630425, -78.73174488544464),
                        new LatLng( 1.368335966964331, -78.73154036700726),
                        new LatLng( 1.368375183084766, -78.73092144727707),


                        new LatLng(1.3684512690602049, -78.73066361993551),
                        new LatLng(1.3687891309836249, -78.73020429164171),
                        new LatLng(1.369222519274017, -78.73015534132719),
                        new LatLng(1.3705404482262602, -78.73386953026056),
                        new LatLng(1.3696964643062375, -78.73002290725708),
                        new LatLng(1.3700195781217046, -78.7295645879166),
                        new LatLng(1.3701513039696596, -78.72898623347282),
                        new LatLng( 1.370117526980078, -78.72848633676767),
                        new LatLng( 1.3700396889386572, -78.72823353856802),
                        new LatLng( 1.3697045086341177, -78.72822817414999),


                        new LatLng(1.3695127854788631, -78.7283505499363),
                        new LatLng(1.369047219920829, -78.728904761374),
                        new LatLng(1.3687975104950107, -78.72890744358301),
                        new LatLng(1.3685256791307612, -78.7288786098361),
                        new LatLng(1.3683198782993469, -78.72880451381207),
                        new LatLng(1.3681030164921013, -78.7286539748311),
                        new LatLng(1.367948163072147, -78.72840218245983),
                        new LatLng( 1.3678908471934033, -78.72807495296001),
                        new LatLng( 1.3679019081525685, -78.7276753038168),
                        new LatLng( 1.3680674873533474, -78.7272026417208),

                        new LatLng(1.3689661062578402, -78.7263160943985),
                        new LatLng(1.3691561535548262, -78.72621785849333),
                        new LatLng(1.369371482536547, -78.72576724737883),
                        new LatLng(1.3693901094658594, -78.72495587915182),
                        new LatLng(1.36919440289402589, -78.72406773269176),
                        new LatLng(1.3692453115407972, -78.72085344046354),
                        new LatLng(1.367948163072147, -78.72840218245983),
                        new LatLng( 1.3691538072919904, -78.72056342661381),
                        new LatLng( 1.369024762832593, -78.72037097811699),
                        new LatLng( 1.3688410839537317, -78.72023485600948),
                        new LatLng( 1.3685524935700435, -78.7201138213277),
                        new LatLng( 1.3665524707583472, -78.7193014472723),
                        new LatLng( 1.366414376277809, -78.71918980032206),

                        new LatLng(1.365809710060827, -78.71855713427067),
                        new LatLng(1.3655197785890691, -78.71846459805965),
                        new LatLng(1.3645852940236085, -78.71837507933378),
                        new LatLng(1.3643335730473691, -78.71830131858587),
                        new LatLng(1.3635492491975707, -78.71783126145601),
                        new LatLng(1.362999887169374, -78.71734108775854),
                        new LatLng(1.3624625915440567, -78.71673692017794),
                        new LatLng( 1.3619296531572576, -78.71601708233355),
                        new LatLng( 1.3617996027657397, -78.71572840958834),
                        new LatLng( 1.3613400689807453, -78.7154283374548),
                        new LatLng( 1.3612897917560483, -78.71528249233961),
                        new LatLng( 1.3613025286530722, -78.71511451900005),
                        new LatLng( 1.3616775967219619, -78.71457673609257),


                        new LatLng(1.3618451874398552, -78.71443390846251),
                        new LatLng(1.3620590331789775, -78.71428739279509),
                        new LatLng(1.3621723244876234, -78.741413115411997),
                        new LatLng(1.3621669615855638, -78.71388472616673),
                        new LatLng(1.3611667801419065, -78.71201455593109),


                        //poco detalle

                        new LatLng(1.143152710095984, -78.4282549470663),
                        new LatLng(1.19166882637245, -78.3138161907196),
                        new LatLng(1.0876599428571165, -78.25590558350088),
                        new LatLng(1.05117081805311552, -78.2862651720643),


                        new LatLng(0.7634504504339018867, -77.87773255258799),
                        new LatLng(0.805932330407246035, -77.83622805029154),
                        new LatLng(0.83044051353187, -77.79734876006842),
                        new LatLng(0.80369150037532974, -77.76439279317856),
                        new LatLng(0.8290274606602241, -77.74157255887985),
                        new LatLng(0.810153345980326, -77.72804953157902),
                        new LatLng(0.7391634432361496, -77.69255116581917),
                        new LatLng(0.7385740768140111, -77.67227835953236),
                        new LatLng(0.707585966822518, -77.66129102557898),
                        new LatLng(0.6891169770381788, -77.6091904565692),
                        new LatLng(0.6492546947803762, -77.57510092109443),
                        new LatLng(0.6587296514033708, -77.49301359057426),
                        new LatLng(0.653804432923835, -77.47610125690699),
                        new LatLng(0.5877639452108131, -77.48806189745665),
                        new LatLng(0.5664387832382454, -77.51088112592697),
                        new LatLng(0.5685197400858251, -77.50983372330666),
                        new LatLng(0.5207708670572045, -77.523355409503),
                        new LatLng(0.4945616849111936, -77.51637294888495),
                        new LatLng(0.47118404626381005, -77.52651304006577),
                        new LatLng(0.47062817722039085, -77.52565171569586),
                        new LatLng(0.4553420376513304, -77.51999594271183),
                        new LatLng(0.4443923158552604, -77.52263255417348),
                        new LatLng(0.4443923158552604, -77.52263255417348),
                        new LatLng(0.4073714787451046, -77.53085352480412),
                        new LatLng(0.42662956459822793, -77.457664757967),
                        new LatLng(0.41904951307447835, -77.45484206825495),
                        new LatLng(0.41756528521813874, -77.43932381272316),
                        new LatLng(0.42336339442619847, -77.42668222635984),
                        new LatLng(0.41958560524444144, -77.41621658205986),
                        new LatLng(0.39705327492153786, -77.39311035722494),
                        new LatLng(0.3916051668939445, -77.39386305212975),
                        new LatLng(0.38511235857756587, -77.38042116165161),
                        new LatLng(0.3904199933847214, -77.37926311790943),
                        new LatLng(0.3958238467942244, -77.38360594958067),
                        new LatLng(0.40013137055609244, -77.3709486052394),
                        new LatLng(0.3923518093553398, -77.360355560112),
                        new LatLng(0.39580104856161236, -77.35771693289281),
                        new LatLng(0.3901313273363624, -77.34839759767056),
                        new LatLng(0.38933942344554767, -77.3281717300415),
                        new LatLng(0.36621861392887983, -77.29569587856531),


                        new LatLng(0.36273248329859553, -77.3270106263345873),
                        new LatLng(0.3696262902226117, -77.26292498409748),
                        new LatLng(0.3625417150034625, -77.21540797501801),
                        new LatLng(0.38958618097412656, -77.169253192842),
                        new LatLng(0.3754365026839916, -77.14675214141607),
                        new LatLng(0.37079537367212656, -77.1143202111125),
                        new LatLng(0.32665507859160514, -77.09637556225061),
                        new LatLng(0.3129777021048216, -77.07981795072556),
                        new LatLng(0.3103971199410054, -77.08027191460133),
                        new LatLng(0.31212913085377214, -77.09359914064407),
                        new LatLng(0.28417921525064654, -77.07663081586361),
                        new LatLng(0.28850053528408826, -77.05888230353594),
                        new LatLng(0.28211159511607798, -77.03964684158564),
                        new LatLng(0.27654540451610976, -77.02790144830942),
                        new LatLng(0.2940338609808597, -77.00957022607327),
                        new LatLng(0.2889618693768962, -76.9986543059349),
                        new LatLng(0.2653362431133957, -76.98147509247065),
                        new LatLng(0.2691275037180929, -76.9696743786335),
                        new LatLng(0.2669482333405435, -76.9522665068507),
                        new LatLng(0.2686554407300304, -76.9450369477272),
                        new LatLng(0.24584448896042535, -76.90705385059118),
                        new LatLng(0.2468144338312918, -76.89572654664515),
                        new LatLng(0.24606040479675442, -76.88499838113785),

                        new LatLng(0.25166214548176846, -76.88059017062187),
                        new LatLng(0.2516383411063456, -76.8728506565094),
                        new LatLng(0.24536337213865836, -76.85779608786106),
                        new LatLng(0.23873133425700285, -76.84665687382221),
                        new LatLng(0.2517731208087618, -76.82982198894025),
                        new LatLng(0.2612646928220401, -76.83572251349688),
                        new LatLng(0.2630557191432628, -76.8270324915675),
                        new LatLng(0.2561920167437022, -76.82270709425211),
                        new LatLng(0.25594290906928807, -76.81095398962498),
                        new LatLng(0.26093210235759534, -76.80703226476908),
                        new LatLng(0.26489603027146835, -76.79820209741592),
                        new LatLng(0.24412420287909162, -76.76804166287184),
                        new LatLng(0.2501993497690667, -76.7531587556004),
                        new LatLng(0.25862341467818467, -76.74752376973629),
                        new LatLng(0.24940274126280834, -76.747922077775),
                        new LatLng(0.2651119457876683, -76.74860503524542),
                        new LatLng(0.2582817717807591, -76.76311947405338),
                        new LatLng(0.2637460453936139, -76.76693323999643),
                        new LatLng(0.2880381953569304, -76.73339892178772),
                        new LatLng(0.26909129489577793, -76.71287029981613),
                        new LatLng(0.27688805272155426, -76.70297965407372),
                        new LatLng(0.26691168863930614, -76.65451414883135),
                        new LatLng(0.24723419564081803, -76.65322300046682),
                        new LatLng(0.25795186341969495, -76.62402648478746),
                        new LatLng(0.21887040551232173, -76.58651813864708),
                        new LatLng(0.21946786319926165, -76.58149804919958),
                        new LatLng(0.24788160779864615, -76.56938955187798),
                        new LatLng(0.25460684696461683, -76.53346974402666),
                        new LatLng(0.23618024011677194, -76.50510102510451),

                        new LatLng(0.24467773872861226, -76.41306102275848),
                        new LatLng(0.24278243993196305, -76.41261611133814),
                        new LatLng(0.3690922968043876, -76.42220869660378),
                        new LatLng(0.3811605472270237, -76.41234621405602),

                        //Cola colombia




                        new LatLng(0.42071411434517547, -76.3068783441782),

                        new LatLng(0.024995840293034744, -75.80053433775902),
                        new LatLng(0.02817172927217261, -75.653707534074),

                        new LatLng(-0.13212650479739946, -75.2655640617013),
                        new LatLng(-0.053126841621284976, -75.2128154039383),
                        new LatLng(-0.24908490250188245, -74.881147518754),
                        new LatLng(-0.20082697128805213, -74.78106390684843),
                        new LatLng(-0.5095596865865356, -74.40653532743453),
                        new LatLng(-0.9934934040089123, -74.13460459560156),


                        new LatLng(-1.2890547690321519, -73.83542329072952),
                        new LatLng(-1.2550175453281114, -73.62883754074574),
                        new LatLng(-1.584349907797453, -73.45421601086854),
                        new LatLng(-1.6944259251167446, -73.56967337429525),
                        new LatLng(-1.81346052376781, -73.43144070357084),

                        new LatLng(-1.7860983979057046, -73.21205712854862),
                        new LatLng(-2.3740573859752887, -73.09515606611967),
                        new LatLng(-2.5387373368800015, -72.24993299692569),
                        new LatLng(-2.19877125677561, -71.7487783357501),
                        new LatLng(-2.416102136075444, -71.23654380440712),

                        new LatLng(-2.246769118566776, -70.935142301023),
                        new LatLng(-2.7510329697241547, -70.07248319685459),

                        new LatLng(-3.797522507692495, -70.71200732141733),
                        new LatLng(-3.8613041981477347, -70.44738359749316),
                        new LatLng(-3.8178596216746903, -70.38326036185026),
                        new LatLng(-3.831421616749017, -70.3826036185026),
                        new LatLng(-4.226557372877319, -69.95257537811995),
                        new LatLng(-4.221122596217317, -69.93321049958466),
                        new LatLng(-1.4443272034522558, -69.43585284054281),

                        new LatLng(-1.5045962564369548, -69.45265084505081),
                        new LatLng(-1.3616246380526786, -69.40481029450895),
                        new LatLng(-1.2138008906358231, -69.42900214344263),
                        new LatLng(-1.1490299303385996, -69.40822843462229),
                        new LatLng(-1.117768531852695, -69.3987575545907),
                        new LatLng(-1.0718605144789919, -69.43263351917267),
                        new LatLng(-1.04469169026224, -69.41944509744644),
                        new LatLng(-1.0258019644789196, -69.43769585341215),
                        new LatLng(-1.000046725193749, -69.43649288266899),
                        new LatLng(-0.9824346241276581, -69.46526929736139),
                        new LatLng(-0.9661284805673963, -69.46317851543427),
                        new LatLng(-0.9400767720214069, -69.50867649167776),
                        new LatLng(-0.927644037923232, -69.49295371770859),
                        new LatLng(-0.9238039511657732, -69.52670361846685),
                        new LatLng(-0.8887069436660001, -69.52218644320965),
                        new LatLng(-0.8602349236975624, -69.5336689800024),
                        new LatLng(-0.8627730123165279, -69.53355867415667),
                        new LatLng(-0.8393847187061558, -69.57191493362188),
                        new LatLng(-0.8315189712169093, -69.57231659442186),
                        new LatLng(-0.8313007294373159, -69.56688310950994),
                        new LatLng(-0.8320127809132867, -69.56746347248553),
                        new LatLng(-0.8277196851829641, -69.56496264785528),
                        new LatLng(-0.8251728574140509, -69.56157200038433),
                        new LatLng(-0.8186007804476613, -69.5586809143424),
                        new LatLng(-0.816639614806085, -69.55886129289865),
                        new LatLng(-0.8150505670715843, -69.559653050404786),
                        new LatLng(-0.816026557312759, -69.56180166453123),
                        new LatLng(-0.8131983534674582, -69.56188414245844),
                        new LatLng(-0.8118429683855897, -69.56281755119562),
                        new LatLng(-0.8110132431854257, -69.5640617609024),
                        new LatLng(-0.8096793129010902, -69.56428237259388),
                        new LatLng(-0.8073530634867895, -69.563467316731632948),
                        new LatLng(-0.8062246359242183, -69.5644935965538),
                        new LatLng(-0.8043831460664432, -69.56864666193722),


                        new LatLng(-0.8044867361788239, -69.57006722688675),
                        new LatLng(-0.8058260320550522, -69.57049202173948)
                        /*
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),

                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                        new LatLng(-, -69.),
                         */




                        )

                .width(10)
                .color(Color.BLUE));

        // Add a circle in Sydney
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(
                        new LatLng(0.653804432923835, -77.47610125690699)
                )
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        circle.setClickable(true);

    }
}