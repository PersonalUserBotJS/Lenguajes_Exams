<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class Contactos extends Migration
{
    public function up()
    {
        Schema::create('contactos', function (Blueprint $table){
            $table->id('id');
            $table->string('codigoEntrada');
            $table->string('nombre');
            $table->string('apellido');
            $table->string('telefono');
        });
    }


    public function down()
    {
        Schema::dropIfExists('contactos');
    }
}
