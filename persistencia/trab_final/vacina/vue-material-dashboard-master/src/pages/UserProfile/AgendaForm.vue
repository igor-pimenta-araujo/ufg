<template>
  <form>
    <md-card>
      <md-card-header :data-background-color="dataBackgroundColor">
        <h4 class="title">Cadastrar Agenda</h4>
      </md-card-header>

      <md-card-content>
        <div class="md-layout">
          <div class="md-layout-item md-small-size-100 md-size-50">
            <md-field>
              <label>Data</label>
              <md-input v-model="data" type="date"></md-input>
            </md-field>
            <md-field>
              <label>Hora</label>
              <md-input v-model="hora" type="time"></md-input>
            </md-field>
            <md-field>
              <label>Usuário</label>
              <md-select v-model="usuario">
                <md-option
                  v-for="item in usuarios"
                  :key="item.id"
                  :value="item.id"
                >
                  {{ item.nome }}
                </md-option>
              </md-select>
            </md-field>
            <md-field>
              <label>Vacina</label>
              <md-select v-model="vacina">
                <md-option
                  v-for="item in vacinas"
                  :key="item.id"
                  :value="item.id"
                >
                  {{ item.titulo }}
                </md-option>
              </md-select>
            </md-field>
          </div>
          <div class="md-layout-item md-size-100 text-right">
            <md-button @click="cadastrarAgenda()" class="md-raised md-success">
              Cadastrar
            </md-button>
          </div>
        </div>
      </md-card-content>
    </md-card>
  </form>
</template>
<script>
export default {
  name: "edit-profile-form",
  props: {
    dataBackgroundColor: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      data: "",
      hora: "",
      usuario: {},
      vacina: {},
      usuarios: [],
      vacinas: [],
    };
  },
  created() {
    this.getUsuarios();
    this.getVacinas();
  },
  methods: {
    async getUsuarios() {
      const response = await this.$axios.get(`http://localhost:8080/usuario`, {
        headers: {},
      });
      this.usuarios = response.data;
    },
    async getVacinas() {
      const response = await this.$axios.get(`http://localhost:8080/vacina`, {
        headers: {},
      });
      this.vacinas = response.data;
    },
    async cadastrarAgenda() {
      const response = await this.$axios.post(
        `http://localhost:8080/agenda`,
        {
          data: this.data,
          hora: this.hora,
          usuario: {
            id: this.usuario,
          },
          vacina: {
            id: this.vacina,
          },
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      this.$router.push("/agenda");
    },
  },
};
</script>
