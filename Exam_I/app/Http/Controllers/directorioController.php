<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\directorioModel;
use Directorio;

class directorioController extends Controller
{
    //VISTA
    public function mostrarDirectorio(){
        $directorio = directorioModel::all();
        return view('directorio', compact('directorio'));
    }


    public function nuevaEntrada(){
        return view('crearEntrada');
    }

    public function buscarEntrada(){
        return view('buscar');
    }
    
    public function eliminarEntrada(){
        return view('eliminar');
    }

    //PROCESOS
    public function agregarEntrada(Request $request){

        $entrada = new directorioModel();

        $entrada->codigoEntrada = $request->input('codigo');
        $entrada->nombre = $request->input('nombre');
        $entrada->apellido = $request->input('apellido');
        $entrada->correo = $request->input('correo');
        $entrada->telefono = $request->input('telefono');
        $entrada->save();

        return redirect('directorio');
    }


}
