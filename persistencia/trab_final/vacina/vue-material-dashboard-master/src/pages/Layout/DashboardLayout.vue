<template>
  <div class="wrapper" :class="{ 'nav-open': $sidebar.showSidebar }">
    <notifications></notifications>

    <side-bar
      :sidebar-item-color="sidebarBackground"
      :sidebar-background-image="sidebarBackgroundImage"
    >
      <mobile-menu slot="content"></mobile-menu>
      <sidebar-link to="/dashboard">
        <md-icon>dashboard</md-icon>
        <p>Dashboard</p>
      </sidebar-link>
      <sidebar-link to="/cadastrar-usuario">
        <md-icon>person</md-icon>
        <p>Cadastrar Usuário</p>
      </sidebar-link>
      <sidebar-link to="/visualizar-usuario">
        <md-icon>person</md-icon>
        <p>Visualizar Usuário</p>
      </sidebar-link>
      <sidebar-link to="/agenda">
        <md-icon>schedule</md-icon>
        <p>Agendamentos</p>
      </sidebar-link>
      <sidebar-link to="/cadastrar-agenda">
        <md-icon>schedule</md-icon>
        <p>Cadastrar Agenda</p>
      </sidebar-link>
      <sidebar-link to="/cadastrar-vacina">
        <md-icon>vaccines</md-icon>
        <p>Cadastrar Vacina</p>
      </sidebar-link>
      <sidebar-link to="/visualizar-vacinas">
        <md-icon>vaccines</md-icon>
        <p>Visualizar Vacinas</p>
      </sidebar-link>
      <sidebar-link to="/cadastrar-alergia">
        <md-icon>coronavirus</md-icon>
        <p>Cadastrar Alergia</p>
      </sidebar-link>
      <sidebar-link to="/visualizar-alergia">
        <md-icon>coronavirus</md-icon>
        <p>Visualizar Alergias</p>
      </sidebar-link>
    </side-bar>

    <div class="main-panel">
      <dashboard-content> </dashboard-content>

      <content-footer v-if="!$route.meta.hideFooter"></content-footer>
    </div>
  </div>
</template>

<script>
import TopNavbar from "./TopNavbar.vue";
import ContentFooter from "./ContentFooter.vue";
import DashboardContent from "./Content.vue";
import MobileMenu from "@/pages/Layout/MobileMenu.vue";
import FixedPlugin from "./Extra/FixedPlugin.vue";

export default {
  components: {
    DashboardContent,
    ContentFooter,
    MobileMenu,
  },
  data() {
    return {
      sidebarBackground: "green",
      sidebarBackgroundImage: require("@/assets/img/sidebar-2.jpg"),
    };
  },
};
</script>
