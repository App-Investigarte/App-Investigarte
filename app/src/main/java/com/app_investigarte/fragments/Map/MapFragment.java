package com.app_investigarte.fragments.Map;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app_investigarte.ListadoArtefactos.ListadoArtefactosActivity;
import com.app_investigarte.R;
import com.app_investigarte.fragments.CreateIcon;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.BitmapDescriptor;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener,  GoogleMap.OnCameraIdleListener,  GoogleMap.OnMarkerClickListener {
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
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        //Configuración del mapa
        this.mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnCameraIdleListener(this);
        this.mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        this.mMap.setOnMarkerClickListener(this);
        //Controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng colombiaPoint = new LatLng(5.5, -72.9);
        LatLng antioquia = new LatLng(6.55, -75.4900048136111);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.7f));
        mMap.addMarker(new MarkerOptions().position(antioquia)
               .title("Departamento de Antioquia")
               .snippet("Population: 6680000"));

        //Ocultar los elementos del mapa con los ajustes de diseño
        try{

            boolean success= mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.style_json_map_night));
            if(!success){
                Log.e("TAG", "Style parsing failed.");
            }
        } catch(Resources.NotFoundException e){
            Log.e("TAG", "No se puede encontrar el error de estilo: ",e);
        }


        //se limita el rango de google map para que solo se vea la region de colombia
        mMap.setMinZoomPreference(5.5f);
        LatLngBounds colombia = new LatLngBounds(
                new LatLng(2, -78), // SW bounds
                new LatLng(9, -67)  // NE bounds
       );

        // Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(colombia);
        //mapaColombia();




    }


    boolean departamentos = false;
    boolean subRegiones = false;
    boolean municipios = false;
    @Override
    public void onCameraIdle() {
        //Configuración del mapa para que deacuerdo al zoom
        //si no tiene zoom y se inicia en la posición inicial se muestra el marcador de antioquía
        //si el zoom esta entre 6 y 8 se muestran las subregions de antioquía
        //si el zoom esta entre 8 y 15 se muestran todos los artefactos en el mapa de antioquía deacuerdo asu municipio
        float zoomMap = mMap.getCameraPosition().zoom;
        //Se crea una variable con el color del mapa de colomvia
        final int colorMap= ContextCompat.getColor(getContext(), R.color.mapa_colombia);

        if(zoomMap <7 && !departamentos) {
            mMap.clear();

            //Dibujamos el pama de colombia
            MapColombia.INSTANCE.mapaColombia(mMap, colorMap);
            LatLng antioquia = new LatLng(6.55, -75.817);
            mMap.addMarker(new MarkerOptions().position(antioquia)
                    .title("Departamento de Antioquia")
                    .snippet("Population: 6680000"));
            departamentos = true;
            subRegiones = false;
            municipios = false;
        }else if(zoomMap >= 7 && zoomMap < 8 && !subRegiones){
            mMap.clear();
            //dibujamos el Mapa De colombia
            MapColombia.INSTANCE.mapaColombia(mMap, colorMap);
            subRegionesAntioquia();
            departamentos = false;
            subRegiones = true;
            municipios = false;
        }else if(zoomMap >= 8 && zoomMap <= 15 && !municipios){
            mMap.clear();
            //dibujamos el Mapa De colombia
            MapColombia.INSTANCE.mapaColombia(mMap, colorMap);
            municipiosAntioquia();
            departamentos = false;
            subRegiones = false;
            municipios = true;
        }

        // Add a marker in Sydney and move the camera
        LatLng colombiaPoint = new LatLng(5.5, -72.9);
        LatLng antioquia = new LatLng(6.55, -75.4900048136111);

        //animacion del zoom de la camara colombia
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(colombiaPoint, 4f), 4000, null);
        //animacion del zoom de la camara Antioquia
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(antioquia, 7.7f),3000, null);
    }


    public void subRegionesAntioquia() {



        /* ---------------------------SubRegiones De Antioquia ------------------------**/
        //Urabá Antioqueño
        //apartado
        int colorUraba = ContextCompat.getColor(getContext(), R.color.color_uraba);
        BitmapDescriptor iconUraba = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_flor, colorUraba, 80);

        LatLng urabaAntioquenio = new LatLng(7.883, -76.633);
        mMap.addMarker(new MarkerOptions()
                .position(urabaAntioquenio)
                .icon(iconUraba)
                .title(getString(R.string.subregion_uraba))).setTag(8);




        //Suroeste Antioqueño
        //Jeríco
        int colorSuroeste = ContextCompat.getColor(getContext(), R.color.color_suroeste);
        BitmapDescriptor iconSuroeste = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_carriel, colorSuroeste, 80);

        LatLng Suroeste = new LatLng(6, -75.883);
        mMap.addMarker(new MarkerOptions().position(Suroeste)
                .icon(iconSuroeste)
                .title(getString(R.string.subregion_suroeste)))
                .setTag(7);


        //OCCIDENTE ANTIOQUEÑO
        //Dabeiba
        int colorOccidente = ContextCompat.getColor(getContext(), R.color.color_occidente);
        BitmapDescriptor iconOccidente = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_sombrero, colorOccidente, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.8, -76.15))
                .title(getString(R.string.subregion_occidente))
                .icon(iconOccidente)
                .zIndex(1.0f)).setTag(5);

        //NORTE ANTIOQUEÑO
        //Ituango
        int colorNorte = ContextCompat.getColor(getContext(), R.color.color_norte);
        BitmapDescriptor iconNorte = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_ruana, colorNorte, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.833, -75.55))
                .title(getString(R.string.subregion_norte))
                .icon(iconNorte)
                .zIndex(1.0f)).setTag(4);

        //VALLE DE ABURRÁ
        //Medellin
        int colorValleAburra = ContextCompat.getColor(getContext(), R.color.color_valle_aburra);
        BitmapDescriptor iconValleAburra = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_flor, colorValleAburra, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.217, -75.567))
                .title(getString(R.string.subregion_valleaburra))
                .icon(iconValleAburra)
                .zIndex(1.0f)).setTag(9);


        //SubReguiones
        //BAJO CAUCA
        int colorBajoCauca= ContextCompat.getColor(getContext(), R.color.color_bajo_cauca);
        BitmapDescriptor iconBajoCauca = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_sombrero, colorBajoCauca, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -75.017))
                .title(getString(R.string.subregion_bajocauca))
                .icon(iconBajoCauca)
                .zIndex(1.0f)).setTag(1);

        //MAGDALENA MEDIO
        //puerto berrio
        int colorMagdalenaMedio= ContextCompat.getColor(getContext(), R.color.color_magdalena_medio);
        BitmapDescriptor iconMagdalenaMedio = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_ruana, colorMagdalenaMedio, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.49998, -74.5525))
                .title(getString(R.string.subregion_megdalenamedio))
                .icon(iconMagdalenaMedio)
                .zIndex(1.0f)).setTag(2);


        //NORDESTE ANTIOQUEÑO
        //Remedios
        int colorNordeste= ContextCompat.getColor(getContext(), R.color.color_nordeste);
        BitmapDescriptor iconNordeste = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_carriel, colorNordeste, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.9595, -74.894))
                .title(getString(R.string.subregion_nordeste))
                .icon(iconNordeste)
                .zIndex(1.0f)).setTag(3);

        //ORIENTE ANTIOQUEÑO
        //Guatapé
        int colorOriente= ContextCompat.getColor(getContext(), R.color.color_oriente);
        BitmapDescriptor iconOriente = CreateIcon.INSTANCE.vectorToBitmap(getContext(), R.drawable.ic_flor, colorOriente, 80);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.033, -75.15))
                .title(getString(R.string.subregion_orinete))
                .icon(iconOriente)
                .zIndex(1.0f)).setTag(6);
        /* ---------------------------  ------------------------  ------------------------**/
    }
    public void municipiosAntioquia() {
        /* ---------------------------Municipios de las Subregiones De Antioquia ------------------------**/

        //Urabá Antioqueño
        LatLng apartado = new LatLng(7.883, -76.633);
        mMap.addMarker(new MarkerOptions().position(apartado)
                .title(getString(R.string.municipio_apartado)));

        LatLng turbo = new LatLng(8.0926, -76.7282);
        mMap.addMarker(new MarkerOptions().position(turbo)
                .title(getString(R.string.municipio_turbo)));

        LatLng necocli = new LatLng(8.4357, -76.7767);
        mMap.addMarker(new MarkerOptions().position(necocli)
                .title(getString(R.string.municipio_necocli)));

        LatLng chigorodo = new LatLng(7.667, -76.683);
        mMap.addMarker(new MarkerOptions().position(chigorodo)
                .title(getString(R.string.municipio_chigorodo)));

        LatLng sanPedroUraba = new LatLng(8.283, -76.383);
        mMap.addMarker(new MarkerOptions().position(sanPedroUraba)
                .title(getString(R.string.municipio_sanpedrodeuraba)));

        LatLng mutata = new LatLng(7.233, -76.433);
        mMap.addMarker(new MarkerOptions().position(mutata)
                .title(getString(R.string.municipio_mutata)));


        //Suroeste Antioqueño
        LatLng jerico = new LatLng(6.267, -75.783);
        mMap.addMarker(new MarkerOptions().position(jerico)
                .title(getString(R.string.municipio_jerico)));

        LatLng jardin = new LatLng(5.6, -75.817);
        mMap.addMarker(new MarkerOptions().position(jardin)
                .title(getString(R.string.municipio_jardin)));

        LatLng amaga = new LatLng(6.05, -75.683);
        mMap.addMarker(new MarkerOptions().position(amaga)
                .title(getString(R.string.municipio_amaga)));

        LatLng andes = new LatLng(5.65, -75.867);
        mMap.addMarker(new MarkerOptions().position(andes)
                .title(getString(R.string.municipio_andes)));

        LatLng betania = new LatLng(5.733, -75.967);
        mMap.addMarker(new MarkerOptions().position(betania)
                .title(getString(R.string.municipio_betania)));

        LatLng caramanta = new LatLng(5.617, -75.85);
        mMap.addMarker(new MarkerOptions().position(caramanta)
                .title(getString(R.string.municipio_caramanta)));

        LatLng ciudadBolivar = new LatLng(5.85, -76.017);
        mMap.addMarker(new MarkerOptions().position(ciudadBolivar)
                .title(getString(R.string.municipio_ciudadbolivar)));

        LatLng concordia = new LatLng(6.05, -75.9);
        mMap.addMarker(new MarkerOptions().position(concordia)
                .title(getString(R.string.municipio_concordia)));

        LatLng hispania = new LatLng(5.8, -75.9);
        mMap.addMarker(new MarkerOptions().position(hispania)
                .title(getString(R.string.municipio_hispania)));

        LatLng salgar = new LatLng(5.95, -75.967);
        mMap.addMarker(new MarkerOptions().position(salgar)
                .title(getString(R.string.municipio_salgar)));

        LatLng tarso = new LatLng(5.867, -75.817);
        mMap.addMarker(new MarkerOptions().position(tarso)
                .title(getString(R.string.municipio_tarso)));

        LatLng titiribi = new LatLng(6.05, -75.783);
        mMap.addMarker(new MarkerOptions().position(titiribi)
                .title(getString(R.string.municipio_titiribi)));

        LatLng urrao = new LatLng(6.317, -76.133);
        mMap.addMarker(new MarkerOptions().position(urrao)
                .title(getString(R.string.municipio_urrao)));

        LatLng fredonia = new LatLng(5.917, -75.667);
        mMap.addMarker(new MarkerOptions().position(fredonia)
                .title(getString(R.string.municipio_fredonia)));

        LatLng valparaiso = new LatLng(5.617, -75.633);
        mMap.addMarker(new MarkerOptions().position(valparaiso)
                .title(getString(R.string.municipio_valparaiso)));


        //OCCIDENTE ANTIOQUEÑO
        //Dabeiba
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7, -76.25))
                .title(getString(R.string.municipio_dabeiba)));

        //Santa Fé de Antioquia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.55, -75.817))
                .title(getString(R.string.municipio_santafedeantioquia)));

        //Buriticá
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.717, -75.917))
                .title(getString(R.string.municipio_buritica)));

        //Cañasgordas
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.74972, -76.0258))
                .title(getString(R.string.municipio_caniasgordas)));
        //Ebéjico
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.317, -75.767))
                .title(getString(R.string.municipio_ebejico)));

        //Frontino
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.767, -76.117))
                .title(getString(R.string.municipio_frontino)));

        //Heliconia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.2, -75.733))
                .title(getString(R.string.municipio_heliconia)));

        //Peque
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  7.017, -75.9))
                .title(getString(R.string.municipio_peque)));

        //Sabanalarga
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.85, -75.817))
                .title(getString(R.string.municipio_sanalarga)));

        //San Jerónimo
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.433, -75.717))
                .title(getString(R.string.municipio_sanjeronimo)));

        //Abriaquí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.633, -76.05))
                .title(getString(R.string.municipio_abriqui)));





        //NORTE ANTIOQUEÑO
        //Ituango
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.233, -75.15))
                .title(getString(R.string.municipio_ituango)));

        //Municipio de Carolina del Príncipe
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.7, -75.283))
                .title(getString(R.string.municipio_carolina)));

        //Municipio de Don Matías
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.483, -75.417))
                .title(getString(R.string.municipio_donmatias)));

        //Municipio de San Pedro de los Milagros
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.45,  -75.55))
                .title(getString(R.string.municipio_sanpedrodelosmilagros)));

        //Municipio de Santa Rosa de Osos
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 6.633,  -75.467))
                .title(getString(R.string.municipio_santarosa)));

        //Municipio de Yarumal
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  6.95,  -75.417))
                .title(getString(R.string.municipio_yarumal)));

        //VALLE DE ABURRÁ
        //Medellin
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.217, -75.567))
                .title(getString(R.string.municipio_medellin)));

        //Girardota
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.367, -75.433))
                .title(getString(R.string.girardota)));


        //BAJO CAUCA
        //El Bagre
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -74.8))
                .title(getString(R.string.municipio_delbagre)));

        //Zaragoza
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.483, -74.867))
                .title(getString(R.string.municipio_zaragoza)));

        //Tarazá
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.583, -75.4))
                .title(getString(R.string.municipio_taraza)));

        //Nechí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(8.083, -74.767))
                .title(getString(R.string.municipio_nechi)));

        //Caucasia
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.983, -75.2))
                .title(getString(R.string.municipio_caucasia)));


        //MAGDALENA MEDIO
        //Caracolí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.4, -74.767))
                .title(getString(R.string.municipio_caracoli)));

        //puerto berrio
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.48998, -74.4025))
                .title(getString(R.string.municipio_puertoberrio)));

        //Puerto Nare
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.19175, -74.5862))
                .title(getString(R.string.municipio_puertonare)));

        //NORDESTE ANTIOQUEÑO
        //Anorí
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.067, -75.1333))
                .title(getString(R.string.municipio_anori)));

        //Remedios
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.03207, -74.5334))
                .title(getString(R.string.municipio_remedios)));

        //Amalfi
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.067, -75.1333))
                .title(getString(R.string.municipio_amalfi)));

        //San Roque
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.467, -75))
                .title(getString(R.string.municipio_sanroque)));

        //Santo Domingo
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.467, -75.167))
                .title(getString(R.string.municipio_santodomingo)));

        //Yolombó
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.583, -75))
                .title(getString(R.string.municipio_yolombo)));


        //ORIENTE ANTIOQUEÑO
        //Carmen de Viboral
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.083, -75.333))
                .title(getString(R.string.municipio_carmendeviboral)));

        //Sonsón
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.7, -75.3))
                .title(getString(R.string.municipio_sonson)));

        /* ---------------------------  ------------------------  ------------------------**/
    }


    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }
    Intent intent;
    //se captura el evento de click en un marcador
    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Integer subregion = (Integer) marker.getTag();

        //de acuerdo a la subregion seleccionada se abre la activity de lista de artefactos y se muestra los artefactos de esa region.
        if(subregion != null){
            Toast.makeText(getContext(),""+subregion, Toast.LENGTH_SHORT).show();
            intent = new Intent(getContext(), ListadoArtefactosActivity.class);
            intent.putExtra("subregion",subregion);
            startActivity(intent);
        }else{
            //si la subregion seleccionada es nula es por que se selecciono el marcado de antioquía
            Toast.makeText(getContext(), R.string.reguion_antioquia, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}