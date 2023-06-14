<template>
  <div class="content">
    <div class="md-layout">
      <div
        class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25"
      >
        <stats-card data-background-color="green">
          <template slot="header">
            <md-icon>person</md-icon>
          </template>

          <template slot="content">
            <p class="category">Usuários</p>
            <h3 class="title">{{ usuarios.length }}</h3>
          </template>

          <template slot="footer">
            <div class="stats">
              <md-icon>person</md-icon>
              Número de usuários cadastrados
            </div>
          </template>
        </stats-card>
      </div>
      <div
        class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25"
      >
        <stats-card data-background-color="orange">
          <template slot="header">
            <md-icon>schedule</md-icon>
          </template>

          <template slot="content">
            <p class="category">Agendamentos</p>
            <h3 class="title">{{ agendamentos.length }}</h3>
          </template>

          <template slot="footer">
            <div class="stats">
              <md-icon>schedule</md-icon>
              Número de agendamentos cadastrados
            </div>
          </template>
        </stats-card>
      </div>
      <div
        class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25"
      >
        <stats-card data-background-color="red">
          <template slot="header">
            <md-icon>vaccines</md-icon>
          </template>

          <template slot="content">
            <p class="category">Vacinas</p>
            <h3 class="title">{{ vacinas.length }}</h3>
          </template>

          <template slot="footer">
            <div class="stats">
              <md-icon>vaccines</md-icon>
              Número de vacinas cadastradas
            </div>
          </template>
        </stats-card>
      </div>
      <div
        class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25"
      >
        <stats-card data-background-color="blue">
          <template slot="header">
            <md-icon>coronavirus</md-icon>
          </template>

          <template slot="content">
            <p class="category">Alergias</p>
            <h3 class="title">{{ alergias.length }}</h3>
          </template>

          <template slot="footer">
            <div class="stats">
              <md-icon>coronavirus</md-icon>
              Número de alergias cadastradas
            </div>
          </template>
        </stats-card>
      </div>
    </div>
  </div>
</template>

<script>
import { StatsCard } from "@/components";

export default {
  components: {
    StatsCard,
  },
  created() {
    this.getUsuarios();
    this.getAgendamentos();
    this.getVacinas();
    this.getAlergias();
  },
  data() {
    return {
      usuarios: [],
      agendamentos: [],
      vacinas: [],
      alergias: [],
    };
  },
  methods: {
    async getUsuarios() {
      const response = await this.$axios.get(`http://localhost:8080/usuario`, {
        headers: {},
      });
      this.usuarios = response.data;
    },
    async getAgendamentos() {
      const response = await this.$axios.get(`http://localhost:8080/agenda`, {
        headers: {},
      });
      this.agendamentos = response.data;
    },
    async getVacinas() {
      const response = await this.$axios.get(`http://localhost:8080/vacina`, {
        headers: {},
      });
      this.vacinas = response.data;
    },
    async getAlergias() {
      const response = await this.$axios.get(`http://localhost:8080/alergia`, {
        headers: {},
      });
      this.alergias = response.data;
    },
  },
};
</script>
