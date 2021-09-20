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
        mMap.addMarker(new MarkerOptions().position(antioquia).title("Departamento de Antioquia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.0f));

        mMap.setMinZoomPreference(5.5f);

        LatLngBounds colombia = new LatLngBounds(
                new LatLng(2, -78), // SW bounds
                new LatLng(9, -67)  // NE bounds
        );

        // Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(colombia);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.00, -73.817))
                .title("San Francisco")
                .snippet("Population: 776733"));

        // Add a circle in Sydney
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(6.00, -75.817))
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        circle.setClickable(true);

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
                        new LatLng(1.3611667801419065, -78.71201455593109)
                )

                .width(2)
                .color(Color.BLUE));

    }
}