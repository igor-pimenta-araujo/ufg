import DashboardLayout from "@/pages/Layout/DashboardLayout.vue";

import Dashboard from "@/pages/Dashboard.vue";
import Home from "@/pages/Home.vue";
import UserProfile from "@/pages/UserProfile.vue";
import CadastrarUsuario from "@/pages/CadastrarUsuario.vue";
import CadastrarVacina from "@/pages/CadastrarVacina.vue";
import CadastrarAlergia from "@/pages/CadastrarAlergia.vue";
import CadastrarAgenda from "@/pages/CadastrarAgenda.vue";
import VisualizarUsuario from "@/pages/VisualizarUsuario.vue";
import VisualizarUsuarioPorId from "@/pages/VisualizarUsuarioPorId.vue";
import VisualizarVacinas from "@/pages/VisualizarVacinas.vue";
import VisualizarAgendamentos from "@/pages/VisualizarAgendamentos.vue";
import VisualizarAlergias from "@/pages/VisualizarAlergias.vue";
import TableList from "@/pages/TableList.vue";
import Typography from "@/pages/Typography.vue";
import Icons from "@/pages/Icons.vue";
import Maps from "@/pages/Maps.vue";
import Notifications from "@/pages/Notifications.vue";
import UpgradeToPRO from "@/pages/UpgradeToPRO.vue";

const routes = [
  {
    path: "/",
    component: DashboardLayout,
    redirect: "/dashboard",
    children: [
      {
        path: "dashboard",
        name: "Tela inicial",
        component: Home,
      },
      {
        path: "cadastrar-usuario",
        name: "Cadastro de usuário",
        component: CadastrarUsuario,
      },
      {
        path: "visualizar-usuario",
        name: "visualizarUsuario",
        component: VisualizarUsuario,
      },
      {
        path: "usuario/:id",
        name: "VisualizarUsuarioPorId",
        component: VisualizarUsuarioPorId,
        props: true,
      },
      {
        path: "agenda",
        name: "Visualizar Agendamentos",
        component: VisualizarAgendamentos,
      },
      {
        path: "cadastrar-agenda",
        name: "Cadastrar Agendamentos",
        component: CadastrarAgenda,
      },
      {
        path: "cadastrar-vacina",
        name: "Cadastro de vacina",
        component: CadastrarVacina,
      },
      {
        path: "visualizar-vacinas",
        name: "Visualizar Vacinas",
        component: VisualizarVacinas,
      },
      {
        path: "cadastrar-alergia",
        name: "Cadastro de alergia",
        component: CadastrarAlergia,
      },
      {
        path: "visualizar-alergia",
        name: "Visualizar de alergia",
        component: VisualizarAlergias,
      },
      {
        path: "table",
        name: "Table List",
        component: TableList,
      },
      {
        path: "typography",
        name: "Typography",
        component: Typography,
      },
      {
        path: "icons",
        name: "Icons",
        component: Icons,
      },
      {
        path: "maps",
        name: "Maps",
        meta: {
          hideFooter: true,
        },
        component: Maps,
      },
      {
        path: "notifications",
        name: "Notifications",
        component: Notifications,
      },
      {
        path: "upgrade",
        name: "Upgrade to PRO",
        component: UpgradeToPRO,
      },
    ],
  },
];

export default routes;
