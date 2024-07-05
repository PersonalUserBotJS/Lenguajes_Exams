<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\contactosModel;

class contactosController extends Controller
{
    // VISTA
    public function verContactos(){
        return view('vercontactos');
    }

    public function agregarContacto(){
        return view('agregarcontacto');
    }

    //PROCESOS
    public function crearContacto(Request $request){
        $contacto  = new contactosModel();

        $contacto->codigoEntrada = $request->input('codigo');
        $contacto->nombre = $request->input('nombre');
        $contacto->apellido = $request->input('apellido');
        $contacto->telefono = $request->input('telefono');
        $contacto->save();

        return redirect('vercontactos');
    }


}
