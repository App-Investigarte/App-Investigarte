package com.app_investigarte.fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app_investigarte.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener,  GoogleMap.OnCameraIdleListener {
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapa) ;
        if (mMapFragment != null) {
            mMapFragment.getMapAsync(this);
        }
        //  getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        //Configuración del mapa
        this.mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnCameraIdleListener(this);
        this.mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng antioquia = new LatLng(6.55, -75.3900048136111);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.5f));
        mMap.addMarker(new MarkerOptions().position(antioquia)
               .title("Departamento de Antioquia")
               .snippet("Population: 6680000"));

        //Ocultar los elementos del mapa con los ajustes de diseño
        try{
            boolean success= mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.style_json_map));
            if(!success){
                Log.e("TAG", "Style parsing failed.");
            }
        } catch(Resources.NotFoundException e){
            Log.e("TAG", "No se puede encontrar el error de estilo: ",e);
        }

        mMap.setMinZoomPreference(5.5f);
        LatLngBounds colombia = new LatLngBounds(
                new LatLng(2, -78), // SW bounds
                new LatLng(9, -67)  // NE bounds
       );

        // Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(colombia);
        mapaColombia();
    }


    boolean departamentos = false;
    boolean subRegiones = false;
    boolean municipios = false;
    @Override
    public void onCameraIdle() {
        float zoomMap = mMap.getCameraPosition().zoom;
        if(zoomMap<=6 && departamentos == false) {
            mMap.clear();
            mapaColombia();
            LatLng antioquia = new LatLng(6.55, -75.817);
            mMap.addMarker(new MarkerOptions().position(antioquia)
                    .title("Departamento de Antioquia")
                    .snippet("Population: 6680000"));
            departamentos = true;
            subRegiones = false;
            municipios = false;
        }else if(zoomMap >= 6 && zoomMap <= 8 && subRegiones == false){
            mMap.clear();
            mapaColombia();
            subRegionesAntioquia();
            departamentos = false;
            subRegiones = true;
            municipios = false;
        }else if(zoomMap >= 8 && zoomMap <= 15 && municipios == false){
            mMap.clear();
            mapaColombia();
            municipiosAntioquia();
            departamentos = false;
            subRegiones = false;
            municipios = true;
        }
    }

    public void subRegionesAntioquia() {
        /* ---------------------------SubRegiones De Antioquia ------------------------**/
        //Urabá Antioqueño
        //apartado
        LatLng urabaAntioquenio = new LatLng(7.883, -76.633);
        mMap.addMarker(new MarkerOptions().position(urabaAntioquenio)
                .title("URABA ANTIOQUEÑO"));

        //Suroeste Antioqueño
        //Jeríco
        LatLng Suroeste = new LatLng(6, -75.883);
        mMap.addMarker(new MarkerOptions().position(Suroeste)
                .title("SUROESTE ANTIOQUEÑO"));


        //OCCIDENTE ANTIOQUEÑO
        //Dabeiba
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.8, -76.15))
                .title("OCCIDENTE ANTIOQUEÑO")
                .zIndex(1.0f));

        //NORTE ANTIOQUEÑO
        //Ituango
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.833, -75.55))
                .title("NORTE ANTIOQUEÑO")
                .zIndex(1.0f));

        //VALLE DE ABURRÁ
        //Medellin
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.217, -75.567))
                .title("VALLE DE ABURRÁ")
                .zIndex(1.0f));


        //SubReguiones
        //BAJO CAUCA
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -75.017))
                .title("BAJO CAUCA")
                .zIndex(1.0f));

        //MAGDALENA MEDIO
        //puerto berrio
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.49998, -74.5525))
                .title("MAGDALENA MEDIO")
                .zIndex(1.0f));


        //NORDESTE ANTIOQUEÑO
        //Remedios
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.9595, -74.894))
                .title("NORDESTE ANTIOQUEÑO")
                .zIndex(1.0f));

        //ORIENTE ANTIOQUEÑO
        //Guatapé
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.033, -75.15))
                .title("ORIENTE ANTIOQUEÑO")
                .zIndex(1.0f));
        /* ---------------------------  ------------------------  ------------------------**/
    }
    public void municipiosAntioquia() {
        /* ---------------------------Municipios de las Subregiones De Antioquia ------------------------**/

        //Urabá Antioqueño
        LatLng apartado = new LatLng(7.883, -76.633);
        mMap.addMarker(new MarkerOptions().position(apartado)
                .title("Municipio de Apartadó"));

        LatLng turbo = new LatLng(8.0926, -76.7282);
        mMap.addMarker(new MarkerOptions().position(turbo)
                .title("Municipio de Turbo"));

        LatLng necocli = new LatLng(8.4357, -76.7767);
        mMap.addMarker(new MarkerOptions().position(necocli)
                .title("Municipio de Necoclí"));

        LatLng chigorodo = new LatLng(7.667, -76.683);
        mMap.addMarker(new MarkerOptions().position(chigorodo)
                .title("Municipio de Chigorodó"));

        LatLng sanPedroUraba = new LatLng(8.283, -76.383);
        mMap.addMarker(new MarkerOptions().position(sanPedroUraba)
                .title("Municipio de San Pedro de Urabá"));

        LatLng mutata = new LatLng(7.233, -76.433);
        mMap.addMarker(new MarkerOptions().position(mutata)
                .title("Municipio de Mutatá"));


        //Suroeste Antioqueño
        LatLng jerico = new LatLng(6.267, -75.783);
        mMap.addMarker(new MarkerOptions().position(jerico)
                .title("Municipio de Jericó"));

        LatLng jardin = new LatLng(5.6, -75.817);
        mMap.addMarker(new MarkerOptions().position(jardin)
                .title("Municipio de Jardín"));

        LatLng amaga = new LatLng(6.05, -75.683);
        mMap.addMarker(new MarkerOptions().position(amaga)
                .title("Municipio de Amagá"));

        LatLng andes = new LatLng(5.65, -75.867);
        mMap.addMarker(new MarkerOptions().position(andes)
                .title("Municipio de Andes"));

        LatLng betania = new LatLng(5.733, -75.967);
        mMap.addMarker(new MarkerOptions().position(betania)
                .title("Municipio de Betania"));

        LatLng caramanta = new LatLng(5.617, -75.85);
        mMap.addMarker(new MarkerOptions().position(caramanta)
                .title("Municipio de Caramanta"));

        LatLng ciudadBolivar = new LatLng(5.85, -76.017);
        mMap.addMarker(new MarkerOptions().position(ciudadBolivar)
                .title("Municipio de Ciudad Bolivar"));

        LatLng concordia = new LatLng(6.05, -75.9);
        mMap.addMarker(new MarkerOptions().position(concordia)
                .title("Municipio de Concordia"));

        LatLng hispania = new LatLng(5.8, -75.9);
        mMap.addMarker(new MarkerOptions().position(hispania)
                .title("Municipio de Hispania"));

        LatLng salgar = new LatLng(5.95, -75.967);
        mMap.addMarker(new MarkerOptions().position(salgar)
                .title("Municipio de Salgar"));

        LatLng tarso = new LatLng(5.867, -75.817);
        mMap.addMarker(new MarkerOptions().position(tarso)
                .title("Municipio de Tarso"));

        LatLng titiribi = new LatLng(6.05, -75.783);
        mMap.addMarker(new MarkerOptions().position(titiribi)
                .title("Municipio de Titiribí"));

        LatLng urrao = new LatLng(6.317, -76.133);
        mMap.addMarker(new MarkerOptions().position(urrao)
                .title("Municipio de Urrao"));

        LatLng fredonia = new LatLng(5.917, -75.667);
        mMap.addMarker(new MarkerOptions().position(fredonia)
                .title("Municipio de Fredonia"));

        LatLng valparaiso = new LatLng(5.617, -75.633);
        mMap.addMarker(new MarkerOptions().position(valparaiso)
                .title("Municipio de Valparaiso"));


        //OCCIDENTE ANTIOQUEÑO
        //Dabeiba
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7, -76.25))
                .title("Municipio de Valparaiso"));

        //Santa Fé de Antioquia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.55, -75.817))
                .title("Municipio de Santa Fé de Antioquia"));

        //Buriticá
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.717, -75.917))
                .title("Municipio de Buriticá"));

        //Cañasgordas
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.74972, -76.0258))
                .title("Municipio de Cañasgordas"));
        //Ebéjico
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.317, -75.767))
                .title("Municipio de Ebéjico"));

        //Frontino
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.767, -76.117))
                .title("Municipio de Frontino"));

        //Heliconia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.2, -75.733))
                .title("Municipio de Heliconia"));

        //Peque
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  7.017, -75.9))
                .title("Municipio de Peque"));

        //Sabanalarga
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.85, -75.817))
                .title("Municipio de Sabanalarga"));

        //San Jerónimo
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.433, -75.717))
                .title("Municipio de San Jerónimo"));

        //Abriaquí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.633, -76.05))
                .title("Abriaquí"));





        //NORTE ANTIOQUEÑO
        //Ituango
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.233, -75.15))
                .title("Municipio de Ituango"));

        //Municipio de Carolina del Príncipe
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.7, -75.283))
                .title("Municipio de Carolina del Príncipe"));

        //Municipio de Don Matías
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.483, -75.417))
                .title("Municipio de Don Matías"));

        //Municipio de San Pedro de los Milagros
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.45,  -75.55))
                .title("Municipio de San Pedro de los Milagros"));

        //Municipio de Santa Rosa de Osos
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.633,  -75.467))
                .title("Municipio de Santa Rosa de Osos"));

        //Municipio de Yarumal
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.95,  -75.417))
                .title("Municipio de Yarumal"));

        //VALLE DE ABURRÁ
        //Medellin
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.217, -75.567))
                .title("Municipio de Medellin"));

        //Girardota
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.367, -75.433))
                .title("Municipio de Girardota"));


        //BAJO CAUCA
        //El Bagre
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -74.8))
                .title("Municipio del el Bagre"));

        //Zaragoza
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.483, -74.867))
                .title("Municipio de Zaragoza"));

        //Tarazá
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -75.4))
                .title("Municipio de Tarazá"));

        //Nechí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(8.083, -74.767))
                .title("Municipio de Nechí"));

        //Caucasia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.983, -75.2))
                .title("Municipio de Caucasia"));


        //MAGDALENA MEDIO
        //Caracolí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.4, -74.767))
                .title("Municipio de Caracolí"));

        //puerto berrio
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.48998, -74.4025))
                .title("Municipio de puerto berrio"));

        //Puerto Nare
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.19175, -74.5862))
                .title("Municipio de Puerto Nare"));

        //NORDESTE ANTIOQUEÑO
        //Anorí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.067, -75.1333))
                .title("Municipio de Anorí"));

        //Remedios
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.03207, -74.5334))
                .title("Municipio de Remedios"));

        //Amalfi
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.067, -75.1333))
                .title("Municipio de Amalfi"));

        //San Roque
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.467, -75))
                .title("Municipio de San Roque"));

        //Santo Domingo
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.467, -75.167))
                .title("Municipio de Santo Domingo"));

        //Yolombó
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.583, -75))
                .title("Municipio de Yolombó"));


        //ORIENTE ANTIOQUEÑO
        //Carmen de Viboral
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.083, -75.333))
                .title("Municipio de Carmen de Viboral"));

        //Sonsón
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.7, -75.3))
                .title("Municipio de Sonsón"));

        /* ---------------------------  ------------------------  ------------------------**/
    }
    public void mapaColombia() {
        // Add Polyline
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
                        new LatLng(1.4366930325404732, -78.8204673305154),

                        new LatLng(1.4346146379061433, -78.81886135786772),
                        new LatLng(1.4334435500153575, -78.81795812398195),
                        new LatLng(1.4310081947452777, -78.8153610751033),
                        new LatLng(1.429553549708485, -78.8123171031475),
                        new LatLng(1.4276393829114082, -78.80698051303625),
                        new LatLng(1.4276293277498002, -78.80701571702957),
                        new LatLng(1.4286874656819688, -78.80456484854221),
                        new LatLng(1.4284592136066767, -78.80339741706848),

                        new LatLng(1.4278435026825915, -78.80193829536438),
                        new LatLng(1.4270065779883794, -78.80102064460516),
                        new LatLng(1.4257034283188936, -78.79991959780455),
                        new LatLng(1.425041462862138, -78.79945758730173),
                        new LatLng(1.4242437523374214, -78.79929497802),
                        new LatLng(1.417590567682397, -78.79907436668873),
                        new LatLng(1.4161335679639417, -78.79869617521763),
                        new LatLng(1.413511837615847, -78.7978046759963),

                        new LatLng(1.41119800914627718, -78.79667446017265),
                        new LatLng(1.4118101580745936, -78.79628587514162),
                        new LatLng(1.4081386553709812, -78.79360031336546),
                        new LatLng(1.4059660508091365, -78.78832742571831),
                        new LatLng(1.4061500619804939, -78.7860395014286),
                        new LatLng(1.4050332580725653, -78.78231927752485),
                        new LatLng(1.404543902050282, -78.78161117434502),
                        new LatLng(1.39686468603069, -78.78030326217413),
                        new LatLng(1.3956433025791692, -78.78035690635443),

                        new LatLng(1.3915256536432754, -78.77841096371412),
                        new LatLng(1.3907034637022868, -78.77726934850216),
                        new LatLng(1.3901215957193271, -78.7757431715727),
                        new LatLng(1.3904118593739152, -78.76801338046789),
                        new LatLng(1.39046917471026, -78.76690227538347),
                        new LatLng(1.3906501705001375, -78.7658840417862),
                        new LatLng(1.3913614167843535, -78.76522086560726),
                        new LatLng(1.39161078866359, -78.76496907323599),
                        new LatLng(1.3921360113391108, -78.76456841826439),

                        new LatLng(1.3925533068721883, -78.7639766590049),
                        new LatLng(1.392862675320098, -78.7633966282101),
                        new LatLng(1.3929226720133092, -78.75858675688505),
                        new LatLng(1.3913258879929797, -78.75472571700811),
                        new LatLng(1.389103661581765, -78.75222086906433),
                        new LatLng(1.3880404780103726, -78.75144436955452),
                        new LatLng(1.3786437512710799, -78.74696541577578),
                        new LatLng(1.3783102480695761, -78.74596059322357),
                        new LatLng(1.3774149844705836, -78.74528400599957),
                        new LatLng(1.3772111954800388, -78.74498896300784),

                        new LatLng(1.377130752452653, -78.74435126781464),
                        new LatLng(1.3770617055186523, -78.74418497085571),
                        new LatLng(1.3761416381732703, -78.74413333833218),
                        new LatLng(1.3759975110159695, -78.74394122511148),
                        new LatLng(1.3760601895714877, -78.74373637139797),
                        new LatLng(1.3762118384260462, -78.7435697396292),
                        new LatLng(1.3764298924617404, -78.7433809787035),
                        new LatLng(1.3765535736515844, -78.74327201396227),
                        new LatLng(1.377124384046207, -78.74282844364643),
                        new LatLng(1.3772111954800388, -78.74270237982273),

                        new LatLng(1.3772504114549062, -78.7420690432191),
                        new LatLng(1.3770617055186523, -78.74418497085571),
                        new LatLng(1.3771736554009322, -78.74089792370796),
                        new LatLng(1.3769068526788186, -78.74035410583019),
                        new LatLng(1.3760678986985346, -78.73956587165594),
                        new LatLng(1.374979235642586, -78.73879071325064),
                        new LatLng(1.3739133643124688, -78.73776007443668),
                        new LatLng(1.3733720489737014, -78.73735170811415),
                        new LatLng(1.37316892999761, -78.73727861791849),
                        new LatLng(1.372985217964495, -78.73714216053486),

                        new LatLng(1.3723638278797037, -78.7365118414136),
                        new LatLng(1.370979199082273, -78.73488742858171),
                        new LatLng(1.370620221115151, -78.73426046222448),
                        new LatLng(1.3705404482262602, -78.73386953026056),
                        new LatLng(1.3704100631206233, -78.73353727161884),
                        new LatLng(1.3702542043089379, -78.7332958728075),
                        new LatLng(1.3699525420639875, -78.73294819146396),
                        new LatLng(1.3684133936630425, -78.73174488544464),
                        new LatLng(1.368335966964331, -78.73154036700726),
                        new LatLng(1.368375183084766, -78.73092144727707),


                        new LatLng(1.3684512690602049, -78.73066361993551),
                        new LatLng(1.3687891309836249, -78.73020429164171),
                        new LatLng(1.369222519274017, -78.73015534132719),
                        new LatLng(1.3705404482262602, -78.73386953026056),
                        new LatLng(1.3696964643062375, -78.73002290725708),
                        new LatLng(1.3700195781217046, -78.7295645879166),
                        new LatLng(1.3701513039696596, -78.72898623347282),
                        new LatLng(1.370117526980078, -78.72848633676767),
                        new LatLng(1.3700396889386572, -78.72823353856802),
                        new LatLng(1.3697045086341177, -78.72822817414999),


                        new LatLng(1.3695127854788631, -78.7283505499363),
                        new LatLng(1.369047219920829, -78.728904761374),
                        new LatLng(1.3687975104950107, -78.72890744358301),
                        new LatLng(1.3685256791307612, -78.7288786098361),
                        new LatLng(1.3683198782993469, -78.72880451381207),
                        new LatLng(1.3681030164921013, -78.7286539748311),
                        new LatLng(1.367948163072147, -78.72840218245983),
                        new LatLng(1.3678908471934033, -78.72807495296001),
                        new LatLng(1.3679019081525685, -78.7276753038168),
                        new LatLng(1.3680674873533474, -78.7272026417208),

                        new LatLng(1.3689661062578402, -78.7263160943985),
                        new LatLng(1.3691561535548262, -78.72621785849333),
                        new LatLng(1.369371482536547, -78.72576724737883),
                        new LatLng(1.3693901094658594, -78.72495587915182),
                        new LatLng(1.36919440289402589, -78.72406773269176),
                        new LatLng(1.3692453115407972, -78.72085344046354),
                        new LatLng(1.367948163072147, -78.72840218245983),
                        new LatLng(1.3691538072919904, -78.72056342661381),
                        new LatLng(1.369024762832593, -78.72037097811699),
                        new LatLng(1.3688410839537317, -78.72023485600948),
                        new LatLng(1.3685524935700435, -78.7201138213277),
                        new LatLng(1.3665524707583472, -78.7193014472723),
                        new LatLng(1.366414376277809, -78.71918980032206),

                        new LatLng(1.365809710060827, -78.71855713427067),
                        new LatLng(1.3655197785890691, -78.71846459805965),
                        new LatLng(1.3645852940236085, -78.71837507933378),
                        new LatLng(1.3643335730473691, -78.71830131858587),
                        new LatLng(1.3635492491975707, -78.71783126145601),
                        new LatLng(1.362999887169374, -78.71734108775854),
                        new LatLng(1.3624625915440567, -78.71673692017794),
                        new LatLng(1.3619296531572576, -78.71601708233355),
                        new LatLng(1.3617996027657397, -78.71572840958834),
                        new LatLng(1.3613400689807453, -78.7154283374548),
                        new LatLng(1.3612897917560483, -78.71528249233961),
                        new LatLng(1.3613025286530722, -78.71511451900005),
                        new LatLng(1.3616775967219619, -78.71457673609257),


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
                        new LatLng(-0.743274, -69.614674),

                        new LatLng(-0.551025, -69.535023),
                        new LatLng(-0.169616, -70.05159),
                        new LatLng(0.537023, -70.046839),
                        new LatLng(0.570176, -69.80001222),
                        new LatLng(0.669733, -69.676525),
                        new LatLng(0.612745, -69.605801),
                        new LatLng(0.73702, -69.471905),
                        new LatLng(0.612745, -69.355175),
                        new LatLng(0.649822, -69.290631),
                        new LatLng(0.600043, -69.293377),
                        new LatLng(0.606566, -69.19656),
                        new LatLng(0.645016, -69.19759),
                        new LatLng(0.654628, -69.179394),
                        new LatLng(0.62991, -69.124462),

                        new LatLng(0.649471, -69.11324),
                        new LatLng(0.709892, -69.155468),
                        new LatLng(0.713668, -69.180188),
                        new LatLng(0.744565, -69.188427),
                        new LatLng(0.770655, -69.143795),
                        new LatLng(0.847552, -69.166455),
                        new LatLng(0.847895, -69.138646),
                        new LatLng(0.882223, -69.140706),
                        new LatLng(0.917581, -69.191861),
                        new LatLng(0.94161, -69.161992),
                        new LatLng(0.941954, -69.161305),
                        new LatLng(0.978684, -69.217953),
                        new LatLng(1.00134, -69.197354),
                        new LatLng(1.05489, -69.245419),

                        new LatLng(1.087447, -69.378673),
                        new LatLng(1.040076, -69.410602),
                        new LatLng(1.078865, -69.437381),
                        new LatLng(1.075089, -69.570247),
                        new LatLng(1.100834, -69.608013),
                        new LatLng(1.076805, -69.701053),
                        new LatLng(1.120056, -69.700367),
                        new LatLng(1.096715, -69.784824),
                        new LatLng(1.062732, -69.807483),
                        new LatLng(1.078865, -69.847995),
                        new LatLng(1.712657, -69.846516),
                        new LatLng(1.690694, -69.781972),
                        new LatLng(1.731874, -69.725323),
                        new LatLng(1.717461, -69.632283),


                        new LatLng(1.776968, -69.52685),
                        new LatLng(1.7276818809784165, -69.3904547765851),
                        new LatLng(1.719316, -68.172785),
                        new LatLng(1.845598, -68.27715),
                        new LatLng(1.992458, -68.197505),
                        new LatLng(1.805793, -68.038203),
                        new LatLng(1.849716, -67.995631),
                        new LatLng(1.805793, -67.904994),
                        new LatLng(1.87854, -67.917353),
                        new LatLng(2.021279, -67.763545),
                        new LatLng(1.984223, -67.639948),
                        new LatLng(2.103623, -67.580897),
                        new LatLng(2.157145, -67.569911),

                        new LatLng(2.146166, -67.549311),
                        new LatLng(2.164006, -67.442194),
                        new LatLng(2.229876, -67.407862),
                        new LatLng(2.165378, -67.322718),
                        new LatLng(2.099506, -67.383143),
                        new LatLng(1.897755, -67.313105),
                        new LatLng(1.912853, -67.221095),
                        new LatLng(1.852461, -67.197749),
                        new LatLng(1.786576, -67.131831),
                        new LatLng(1.612245, -67.145564),
                        new LatLng(1.605121, -67.152502),
                        new LatLng(1.576293, -67.100317),
                        new LatLng(1.507653, -67.10993),
                        new LatLng(1.460977, -67.075598),


                        new LatLng(1.42391, -67.089331),
                        new LatLng(1.363503, -67.081091),
                        new LatLng(1.334672, -67.11817),
                        new LatLng(1.340164, -67.155249),
                        new LatLng(1.316824, -67.151129),
                        new LatLng(1.25916, -67.100317),
                        new LatLng(1.156186, -67.093451),
                        new LatLng(1.227582, -66.853125),
                        new LatLng(1.2777333, -66.880031),
                        new LatLng(1.305783, -66.870762),
                        new LatLng(1.318139, -66.845699),
                        new LatLng(1.401543, -66.875911),
                        new LatLng(1.4117331, -66.909557),
                        new LatLng(1.479318, -66.910599),


                        new LatLng(1.932541, -67.076767),
                        new LatLng(1.979206, -67.124832),
                        new LatLng(2.066018, -67.091873),
                        new LatLng(2.139777, -67.115219),
                        new LatLng(2.127426, -67.150924),
                        new LatLng(2.250246, -67.225769),
                        new LatLng(2.30582, -67.214096),
                        new LatLng(2.338066, -67.189377),
                        new LatLng(2.671266, -67.495189),
                        new LatLng(2.668522, -67.563854),
                        new LatLng(2.712419, -67.561107),
                        new LatLng(2.745341, -67.59132),
                        new LatLng(2.778597, -67.583475),
                        new LatLng(2.818032, -67.622957),


                        new LatLng(2.79896, -67.649348),
                        new LatLng(2.81542, -67.739985),
                        new LatLng(2.838738, -67.734492),
                        new LatLng(2.819535, -67.786677),
                        new LatLng(2.830508, -67.81277),
                        new LatLng(2.794846, -67.837489),
                        new LatLng(2.789359, -67.8635852),
                        new LatLng(2.860683, -67.858088),
                        new LatLng(3.244658, -67.435115),
                        new LatLng(3.251514, -67.37469),
                        new LatLng(3.29416, -67.377437),
                        new LatLng(3.3845, -67.304652),
                        new LatLng(3.451671, -67.330745),
                        new LatLng(3.465379, -67.400783),


                        new LatLng(3.540769, -67.415889),
                        new LatLng(3.540769, -67.410396),
                        new LatLng(3.577776, -67.437861),
                        new LatLng(3.614782, -67.447474),
                        new LatLng(3.646304, -67.437861),
                        new LatLng(3.657268, -67.452968),
                        new LatLng(3.677826, -67.441981),
                        new LatLng(3.677826, -67.441981),
                        new LatLng(3.686048, -67.469447),
                        new LatLng(3.721679, -67.488673),
                        new LatLng(3.738124, -67.484553),
                        new LatLng(3.769964, -67.502989),
                        new LatLng(3.775617, -67.522902),
                        new LatLng(3.757289, -67.543158),

                        new LatLng(3.754528, -67.60673),
                        new LatLng(3.780564, -67.621149),
                        new LatLng(3.787416, -67.635569),
                        new LatLng(3.822357, -67.646555),
                        new LatLng(3.856613, -67.643122),
                        new LatLng(3.899087, -67.663035),
                        new LatLng(3.916213, -67.679514),
                        new LatLng(3.935394, -67.690501),
                        new LatLng(3.954575, -67.689127),
                        new LatLng(3.977865, -67.697367),
                        new LatLng(4.039512, -67.70492),
                        new LatLng(4.05595, -67.71522),
                        new LatLng(4.138822, -67.738566),
                        new LatLng(4.173064, -67.774958),
                        new LatLng(4.203881, -67.777018),
                        new LatLng(4.229902, -67.801737),
                        new LatLng(4.281259, -67.794184),
                        new LatLng(4.327819, -67.805857),
                        new LatLng(4.3415113, -67.764658),
                        new LatLng(4.491441, -67.804484),
                        new LatLng(4.531144, -67.858042),
                        new LatLng(4.56263, -67.847056),
                        new LatLng(4.63518, -67.844309),
                        new LatLng(4.715934, -67.81959),
                        new LatLng(4.947248, -67.833833),
                        new LatLng(4.986924, -67.818727),
                        new LatLng(5.027965, -67.82422),
                        new LatLng(5.057377, -67.80362),
                        new LatLng(5.064901, -67.823533),
                        new LatLng(5.084735, -67.82216),
                        new LatLng(5.132609, -67.852372),
                        new LatLng(5.19827, -67.821473),
                        new LatLng(5.245718483172038, -67.84392390400171),
                        new LatLng(5.298784, -67.856492),
                        new LatLng(5.472422, -67.624406),
                        new LatLng(5.544186, -67.598313),
                        new LatLng(5.567423, -67.623033),
                        new LatLng(5.591341, -67.618913),
                        new LatLng(5.630976, -67.631272),
                        new LatLng(5.7321, -67.628526),
                        new LatLng(5.833207, -67.597627),
                        new LatLng(5.996441, -67.403993),

                        new LatLng(5.995075, -67.412233),
                        new LatLng(6.139829, -67.497377),
                        new LatLng(6.188981, -67.450685),
                        new LatLng(6.281813, -67.549562),
                        new LatLng(6.328222, -67.81598),
                        new LatLng(6.194443, -68.035707),
                        new LatLng(6.232669, -68.085145),
                        new LatLng(6.156213, -68.315858),
                        new LatLng(6.188981, -68.376283),
                        new LatLng(6.11252, -68.659181),
                        new LatLng(6.224478, -69.060182),
                        new LatLng(6.078197564236162, -69.22358181327581),
                        new LatLng(6.05916691881033, -69.28262561559676),
                        new LatLng(6.062284895416473, -69.28587678819895),
                        new LatLng(6.089634, -69.304246),
                        new LatLng(6.144253, -69.359177),
                        new LatLng(6.116944, -69.433335),
                        new LatLng(6.976468, -70.117234),
                        new LatLng(6.935572, -70.287522),
                        new LatLng(7.077328, -70.556687),
                        new LatLng(7.060974, -70.611619),
                        new LatLng(7.101858, -70.707749),
                        new LatLng(6.990099, -71.007127),
                        new LatLng(6.979194, -71.103257),
                        new LatLng(7.036441, -71.133469),
                        new LatLng(7.020908, -71.458503),
                        new LatLng(7.060433, -71.816932),
                        new LatLng(7.027723, -71.821052),
                        new LatLng(7.001826, -71.946021),
                        new LatLng(7.041352, -72.051765),

                        new LatLng(7.034538, -72.044898),
                        new LatLng(7.25937, -72.176734),
                        new LatLng(7.28389, -72.173988),
                        new LatLng(7.324755, -72.153388),
                        new LatLng(7.372425, -72.183601),
                        new LatLng(7.394216, -72.221195),
                        new LatLng(7.390471, -72.244712),
                        new LatLng(7.377873, -72.25381),
                        new LatLng(7.391151, -72.303077),
                        new LatLng(7.376341, -72.32402),
                        new LatLng(7.396429, -72.355434),
                        new LatLng(7.394045, -72.360069),
                        new LatLng(7.397791, -72.373286),
                        new LatLng(7.402727, -72.429076),
                        new LatLng(7.422303, -72.442638),
                        new LatLng(7.424006, -72.442104),
                        new LatLng(7.445283, -72.442275),
                        new LatLng(7.448006, -72.444164),
                        new LatLng(7.462985, -72.447254),
                        new LatLng(7.469793, -72.454978),
                        new LatLng(7.483239, -72.461845),

                        new LatLng(7.482728, -72.469913),
                        new LatLng(7.491579, -72.474548),
                        new LatLng(7.499237, -72.477809),
                        new LatLng(7.502982, -72.473518),
                        new LatLng(7.524255, -72.471458),
                        new LatLng(7.525617, -72.470256),
                        new LatLng(7.544677, -72.457038),
                        new LatLng(7.554887, -72.45515),
                        new LatLng(7.55795, -72.452232),
                        new LatLng(7.572584, -72.452918),
                        new LatLng(7.576328, -72.453948),
                        new LatLng(7.58943, -72.460643),
                        new LatLng(7.590111, -72.463733),
                        new LatLng(7.624311, -72.472831),
                        new LatLng(7.6352, -72.475406),
                        new LatLng(7.6369794, -72.472659),
                        new LatLng(7.64677, -72.476779),
                        new LatLng(7.651874, -72.472659),
                        new LatLng(7.655787, -72.475406),
                        new LatLng(7.670928, -72.471629),
                        new LatLng(7.680455, -72.475749),

                        new LatLng(7.697297, -72.473518),
                        new LatLng(7.703761, -72.469913),
                        new LatLng(7.758193, -72.473003),
                        new LatLng(7.762786, -72.470943),
                        new LatLng(7.781665, -72.468196),
                        new LatLng(7.798503, -72.466308),
                        new LatLng(7.804455, -72.455837),
                        new LatLng(7.828095, -72.446739),
                        new LatLng(7.838987, -72.450858),
                        new LatLng(7.847141, -72.447597),


                        new LatLng(7.8691, -72.44714242),
                        new LatLng(7.880921875754, -72.45726373046637),
                        new LatLng(7.91933486440552, -72.463367767632),
                        new LatLng(7.918108164205057, -72.4687372148037),
                        new LatLng(7.92306940348555, -72.46566642075778),
                        new LatLng(7.9250123732081565, -72.47050378471613),
                        new LatLng(7.924259560698573, -72.474663539242744),
                        new LatLng(7.929440888614488, -72.476518973708115),
                        new LatLng(7.92940369672175, -72.4785302951932),
                        new LatLng(7.9301548394707435, -72.47968900948763),
                        new LatLng(7.931345640327693, -72.48394601047039),
                        new LatLng(7.932245878173818, -72.48909786343576),
                        new LatLng(7.932733686054304, -72.4897737801075),
                        new LatLng(7.9345716771924675, -72.48998131603003),
                        new LatLng(7.936087557105615, -72.48899325728416),
                        new LatLng(7.938828413186049, -72.4877892807126),
                        new LatLng(7.9402552866056, -72.48637173324823),
                        new LatLng(7.9403801400530325, -72.48581551015377),

                        new LatLng(7.9401041967566, -72.48546984046698),
                        new LatLng(7.939962074264469, -72.48484455049038),
                        new LatLng(7.9400799562415605, -72.48411700129509),
                        new LatLng(7.942104864470845, -72.48345583677292),
                        new LatLng(7.947160782232935, -72.48442813754083),
                        new LatLng(7.949293905350875, -72.48319298028946),
                        new LatLng(7.96296004087766, -72.47119713574648),
                        new LatLng(7.963199776097851, -72.47030999511482),
                        new LatLng(7.963731044783847, -72.46739510446787),
                        new LatLng(7.9632837830046945, -72.46625415980816),
                        new LatLng(7.96338406001353, -72.4634898081422),
                        new LatLng(7.963684558801321, -72.46257416903973),
                        new LatLng(7.964109241259769, -72.4621845781803),
                        new LatLng(7.9663505213719885, -72.4574504792903),
                        new LatLng(7.96630901629622, -72.45569363236427),
                        new LatLng(7.965855448553943, -72.45423551648855),
                        new LatLng(7.965442721394609, -72.45359245687723),
                        new LatLng(7.96543508443743, -72.45259568095207),
                        new LatLng(7.965036302610151, -72.45180912315845),
                        new LatLng(7.96476684697451, -72.45090622454882),
                        new LatLng(7.964250359258332, -72.45026785880327),
                        new LatLng(7.963742998321334, -72.44940519332886),
                        new LatLng(7.963583949835389, -72.4487172061654),
                        new LatLng(7.96424272285539, -72.44801983237267),
                        new LatLng(7.965067514537, -72.44776267558336),
                        new LatLng(7.967481782097011, -72.448725334358),
                        new LatLng(7.968652552305714, -72.44884796440601),
                        new LatLng(7.96945405605285, -72.44864411652088),
                        new LatLng(7.969429522178118, -72.44855761528015),
                        new LatLng(7.97117271844549, -72.44677897542715),
                        new LatLng(7.97229101644885, -72.4461292102933),
                        new LatLng(7.9737931435139915, -72.4448524788022),

                        new LatLng(7.992410560810807, -72.43368208408356),
                        new LatLng(7.989066779528975, -72.4276608602125),
                        new LatLng(7.997114584842824, -72.41823926568031),
                        new LatLng(8.008248575668468, -72.42102473974228),
                        new LatLng(8.011483302360318, -72.41585411131382),
                        new LatLng(8.014534738620481, -72.41751305758983),
                        new LatLng(8.019498129198798, -72.4145307764411),
                        new LatLng(8.020885211737335, -72.41225592792034),
                        new LatLng(8.025141712884954, -72.41256136447191),
                        new LatLng(8.028592762713885, -72.413997120058535),
                        new LatLng(8.030391480093282, -72.4167013540864),
                        new LatLng(8.033214700017409, -72.41606567057987),
                        new LatLng(8.033453065993761, -72.41461459547281),
                        new LatLng(8.033501535938411, -72.4145334586511),
                        new LatLng(8.034472925526561, -72.41393867880107),
                        new LatLng(8.034259791031307, -72.41291608661413),
                        new LatLng(8.034655849279833, -72.41151060909034),
                        new LatLng(8.034654189355038, -72.41080351173878),
                        new LatLng(8.0340318884407245, -72.4105899408497),
                        new LatLng(8.034286017867755, -72.410061374545097),
                        new LatLng(8.034223936616224, -72.41034284234047),
                        new LatLng(8.034023417441505, -72.41020940244199),
                        new LatLng(8.034410180336323, -72.40941580384971),
                        new LatLng(8.034546294228797, -72.40889646112919),
                        new LatLng(8.034474253466993, -72.4087231233716),
                        new LatLng(8.0343411528424, -72.40824468433857),
                        new LatLng(8.0339709673296, -72.40784134715796),
                        new LatLng(8.03385908459782, -72.40720633417368),
                        new LatLng(8.0339533685001, -72.40686703473331),
                        new LatLng(8.03480690240778, -72.40563925355673),
                        new LatLng(8.034939032350525, -72.4053663387846),

                        new LatLng(8.03241228873142, -72.396099306643301),
                        new LatLng(8.035910498485, -72.3885545879024),
                        new LatLng(8.034035036932993, -72.38253101706505),
                        new LatLng(8.03424319176655, -72.38333199173212),
                        new LatLng(8.018772382356744, -72.36435871571304),
                        new LatLng(8.010710728589107, -72.36183743923903),
                        new LatLng(8.004201728073653, -72.34987948089838),
                        new LatLng(8.017356740691188, -72.3464298955299),
                        new LatLng(8.030586357263882, -72.3537656648483),
                        new LatLng(8.037924228034099, -72.3453676700592),
                        new LatLng(8.075060388046616, -72.35125377774239),
                        new LatLng(8.075355161163118, -72.35355410724878),
                        new LatLng(8.077366450817301, -72.34895847737789),
                        new LatLng(8.088019911344825, -72.35970608890057),
                        new LatLng(8.087587723712604, -72.35672347247599),
                        new LatLng(8.0893300810056, -72.35909454524517),
                        new LatLng(8.09384842417225, -72.3701123893261),
                        new LatLng(8.10610200067948, -72.37282946705818),
                        new LatLng(8.116851620987292, -72.36724946647882),
                        new LatLng(8.120181402430413, -72.35810481011868),
                        new LatLng(8.150455521494834, -72.3647934298515),
                        new LatLng(8.156186881376112, -72.35218282788992),
                        new LatLng(8.16530630816738, -72.35391553491354),
                        new LatLng(8.171508381782317, -72.3584833368659),
                        new LatLng(8.259509789490489, -72.38975923508406),
                        new LatLng(8.268889289635396, -72.3884965851903),
                        new LatLng(8.274713498885998, -72.38577581942081),
                        new LatLng(8.277272885475478, -72.38543115556242),
                        new LatLng(8.27822117056776, -72.38424997776747),
                        new LatLng(8.278897626148938, -72.38460771739483),
                        new LatLng(8.278766903949428, -72.38544423133135),
                        new LatLng(8.278417537045875, -72.3860812559724),
                        new LatLng(8.258191220072023, -72.39196736365557),
                        new LatLng(8.316766415378842, -72.3789281398058),
                        new LatLng(8.325561014391166, -72.396897934772),
                        new LatLng(8.357494262652729, -72.38752260804176),
                        new LatLng(8.381284182073449, -72.42509315554174),
                        new LatLng(8.59930990414006, -72.6124382391572),

                        new LatLng(8.615950859029196, -72.6505383476615),
                        new LatLng(9.11122875595093, -72.76617608964443),
                        new LatLng(9.139579391999197, -72.81857371330261),
                        new LatLng(9.120356236269846, -72.82368566840887),
                        new LatLng(9.1297910089223, -72.8452335495472),
                        new LatLng(9.133217801147364, -72.8812358155466),
                        new LatLng(9.102604244663441, -72.88876008242369),
                        new LatLng(9.082595120686022, -72.93280463665724),
                        new LatLng(9.14315306131676, -72.98517778515816),
                        new LatLng(9.181347304965092, -72.95497309416533),
                        new LatLng(9.182510038106292, -72.95319210737944),
                        new LatLng(9.224973824225549, -72.99112927168608),
                        new LatLng(9.226082470905194, -72.98759110271929),

                        new LatLng(9.292668335109486, -72.98922188580035),
                        new LatLng(9.1727992675714312, -73.20185702294111),
                        new LatLng(9.150312539670274, -73.36431372910738),
                        new LatLng(9.8341174474898354, -72.93549858033656),
                        new LatLng(9.951635431103432, -72.98260487616062),
                        new LatLng(10.107824808407477, -72.892711982131),
                        new LatLng(10.445512696772003, -72.87488702684641),
                        new LatLng(11.10846572117147, -72.45167803019285),
                        new LatLng(11.152510474174592, -72.232699804008),
                        new LatLng(11.630612294480056, -71.9655783667564),
                        new LatLng(11.69866158634884, -71.81994941085577),
                        new LatLng(11.841366639813137, -71.32283952087164),
                        new LatLng(11.848169252005613, -71.32292836904526),
                        new LatLng(11.86374955182363, -71.3183002173006)

                )

                .width(10)
                .color(Color.BLUE));


        // Add Polyline
        Polyline line2 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(8.678973577364099, -77.37136434763669),
                        new LatLng(8.64233938741097, -77.37324222922325),
                        new LatLng(8.635531610066707, -77.37349234521389),
                        new LatLng(8.650508027591828, -77.39227116107939),

                        new LatLng(8.649641584705197, -77.39602692425251),
                        new LatLng(8.641351276218499, -77.41029699476398),
                        new LatLng(8.616615169294397, -77.40059304982424),


                        new LatLng(8.584929851675662, -77.3918329551816),
                        new LatLng(8.584561940236966, -77.4189966917038),
                        new LatLng(8.568211614057303, -77.41038613021374),

                        new LatLng(8.587451712781142, -77.41911605000496),
                        new LatLng(8.568128398970348, -77.40938264876604),
                        new LatLng(8.557762839519858, -77.42652866989374),


                        new LatLng(8.56291001412214, -77.4364826595068),
                        new LatLng(8.5128679640736, -77.44358584284782),
                        new LatLng(8.507988978787042, -77.455479428117211),


                        new LatLng(8.47226948154305, -77.446363940835),
                        new LatLng(8.469601610677092, -77.43689416992664),
                        new LatLng(8.47479739232696, -77.4017534404993),


                        new LatLng(7.928547286052519, -77.16720096766947),
                        new LatLng(7.9120274098592445, -77.28656999766825),
                        new LatLng(7.8295284001180026, -77.35370334237814),
                        new LatLng(7.775239837903687, -77.33529534190893),
                        new LatLng(7.76397987171479, -77.38436669111252),
                        new LatLng(7.664011025848014, -77.43980593979359),
                        new LatLng(7.505470646653843, -77.57457822561264),
                        new LatLng(7.658005001526036, -77.64879159629345),
                        new LatLng(7.683901575658946, -77.72584475576878),
                        new LatLng(7.603741934641177, -77.74183575063945),
                        new LatLng(7.439701627916182, -77.71004654467106),
                        new LatLng(7.453375566397509, -77.81595256179571),
                        new LatLng(7.226332694276445, -77.8917048498988)
                )
                .width(10)
                .color(Color.BLUE));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }
}